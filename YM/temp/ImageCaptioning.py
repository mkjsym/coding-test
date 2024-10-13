import pandas as pd
import torch
import torch.nn as nn
from torch import optim
from torch.utils.data import Dataset, DataLoader, random_split
from PIL import Image
from torchvision.transforms import Resize, ToTensor, Normalize, Compose
from matplotlib import pyplot as plt

from torchvision.models import resnet50,ResNet50_Weights 

from io import open
import unicodedata
import re
import os

from tqdm import tqdm

data=pd.read_csv('Python/flickr8k/captions.txt')
data.head()

# GPU 설정
device=torch.device('cuda:0' if torch.cuda.is_available() else 'cpu')

# unicode 2 ascii, remove non-letter characters, trim
# 단어토큰화를 수행하기 때문에 단어가 아닌것들은 제거 하는 코드.

def normalizeString(s): 
    sres=""
    for ch in unicodedata.normalize('NFD', s): 
        #Return the normal form form ('NFD') for the Unicode string s.
        if unicodedata.category(ch) != 'Mn':
            # The function in the first part returns the general 
            # category assigned to the character ch as string. 
            # "Mn' refers to Mark, Nonspacing
            sres+=ch
    #sres = re.sub(r"([.!?])", r" \1", sres) 
    # inserts a space before any occurrence of ".", "!", or "?" in the string sres. 
    sres = re.sub(r"[^a-zA-Z!?,]+", r" ", sres) 
    # this line of code replaces any sequence of characters in sres 
    # that are not letters (a-z or A-Z) or the punctuation marks 
    # "!", "," or "?" with a single space character.
    return sres.strip()

capt_file_path='Python/flickr8k/captions.txt'
images_dir_path='Python/flickr8k/Images/'

#read data
data=open(capt_file_path).read().strip().split('\n')
data=data[1:]

img_filenames_list=[]
captions_list=[]

# caption 만 추출함.
for s in data:
    templist=s.lower().split(",")
    img_path=templist[0]
    caption=",".join(s for s in templist[1:])
    caption=normalizeString(caption)
    img_filenames_list.append(img_path)
    captions_list.append(caption)

captions_list

# 주어진 문장을 기반으로 어휘 사전을 구축하는 class 로. / SOS, EOS , 중복되지 않도록 단어들을 추가함.
class Vocab:
    def __init__(self):
        self.word2index={'SOS':0, 'EOS':1}
        self.index2word={0:'SOS', 1:'EOS'}
        self.word2count={}
        self.nwords=2
    
    def buildVocab(self,s):
        for word in s.split(" "):
            # 단어(Word)가 없을 때만 if문을 돔.
            if word not in self.word2index:
                self.word2index[word]=self.nwords # word2index에 word를 key로, nwords를 value로 추가
                self.index2word[self.nwords]=word # index2word에 nwords를 key로, word를 value로 추가
                self.word2count[word]=1 # word2count는 단어가 나온 횟수를 저장함.
                self.nwords+=1  # nwords = number of words
            else:
                self.word2count[word]+=1

#create Vocab objects for each language
vocab=Vocab()

#build the vocab from caption_list
for caption in captions_list:
    vocab.buildVocab(caption)


#print vocab size
print("Vocab Length:",vocab.nwords)
print()
print(vocab.word2index)
print(vocab.index2word)
print()
print(vocab.word2count)

class CustomDataset(Dataset):
    def __init__(self,images_dir_path, img_filenames_list, captions_list, vocab, max_cap_length):
        super().__init__()
        self.images_dir_path=images_dir_path
        self.img_filenames_list=img_filenames_list
        self.captions_list=captions_list
        self.length=len(self.captions_list)
        self.transform=Compose([Resize((224,224), antialias=True),
                                 ToTensor(), 
                                 Normalize(mean=[0.485, 0.456, 0.406],std=[0.229, 0.224, 0.225])])
        self.vocab=vocab
        self.max_cap_length=max_cap_length
    
    def __len__(self):
        return self.length
    
    # 각 토큰을 고유한 숫자 식별자로 매핑하는 함수.
    def get_input_ids(self, sentence,vocab):
        input_ids=[0]*(self.max_cap_length+1)
        i=0
        # 단어 토큰화라서 Split 함수(공백을 기준으로 토큰화 진행) 적용.
        for word in sentence.split(" "):
            input_ids[i]=vocab.word2index[word]
            i=i+1

        input_ids.insert(0,vocab.word2index['SOS'])
        i=i+1
        input_ids[i]=vocab.word2index['EOS']

        # torch 형태로 변환함.
        return torch.tensor(input_ids)
    
    def __getitem__(self,idx):
        imgfname,caption=self.img_filenames_list[idx],self.captions_list[idx]
        
        imgfname=self.images_dir_path+imgfname
        img=Image.open(imgfname)
        img=self.transform(img)
        
        caption=self.get_input_ids(caption,self.vocab)       
        
        return img,caption
    
max_cap_length=73   # 데이터셋의 Caption의 길이가 다르기 때문에 최대 길이를 설정함. max_cap_length보다 짧은 caption은 0으로 padding을 수행해야함.

dataset=CustomDataset(images_dir_path, img_filenames_list, captions_list, vocab, max_cap_length)
train_dataset,test_dataset=random_split(dataset,[0.999,0.001])

batch_size=64
train_dataloader=DataLoader(dataset=train_dataset,batch_size=batch_size, shuffle=True)
test_dataloader=DataLoader(dataset=test_dataset,batch_size=1, shuffle=False)

# 데이터 수 확인
print('Total dataset :',len(dataset))
print('Train dataset :',len(train_dataset))
print('Test dataset : ',len(test_dataset))

# shape 확인
for idx, i in enumerate(train_dataloader):
    print('Index',idx)
    print(i[0].shape) # torch.Size([64, 3, 224, 224])
    print(i[1].shape) # torch.Size([64, 75]) 
    break

## Encoder 구현
class Encoder(nn.Module):
    def __init__(self, pretrained_feature_extractor):
        super().__init__()
        self.pretrained_feature_extractor=pretrained_feature_extractor
        
    def forward(self,x):
        features=self.pretrained_feature_extractor(x)

        for name, param in self.pretrained_feature_extractor.named_parameters():
            if "fc.weight" in name or "fc.bias" in name:
                param.requires_grad = True
            else:
                param.requires_grad = False
                    
        return features
    
pretrained_feature_extractor=resnet50(weights=ResNet50_Weights.DEFAULT)
# pretrained_feature_extractor=resnet50(pretrained=True)
pretrained_feature_extractor.fc=nn.Linear(2048,1024)

encoder=Encoder(pretrained_feature_extractor).to(device)

class Decoder(nn.Module):
    def __init__(self,output_size,embed_size,hidden_size):
        super().__init__()
        # num_embeddings :임베딩을 할 단어들의 개수, 즉, 단어 집합의 크기
        # embeding_dim : 임베딩 할 벡터의 차원, 사용자가 정의 하는 하이퍼 파라미터.
        # padding_idx : 패딩을 위한 토큰의 인덱스 알려줌. (선택적으로 사용함)
        self.e=nn.Embedding(num_embeddings=output_size,
                            embedding_dim=embed_size)
        self.relu=nn.ReLU()
        self.gru=nn.GRU(embed_size, hidden_size, batch_first=True)
        self.lin=nn.Linear(hidden_size,output_size)
        self.lsoftmax=nn.LogSoftmax(dim=-1)
    
    def forward(self,x,prev_hidden):
        x=self.e(x)
        x=self.relu(x)
        output,hidden=self.gru(x,prev_hidden)
        y=self.lin(output)
        y=self.lsoftmax(y)
        return y, hidden
    
embed_size=300
hidden_size=1024

# vocab.nwords : (8446) 임베딩을 할 단어들의 개수, 즉, 단어 집합의 크기
# embed_size : 300
decoder=Decoder(vocab.nwords,embed_size,hidden_size).to(device)

def train_one_epoch(epoch):
    encoder.train()
    decoder.train()
    track_loss=0

    # 배치 사이즈만큼 데이터를 가져옴.
    for idx, (imgs,caption) in tqdm(enumerate(train_dataloader)):
        # imgs size : torch.Size([64, 3, 224, 224])
        # caption size : torch.Size([64, 75])
        imgs=imgs.to(device)
        caption=caption.to(device)
        # extracted_features : [64, 1024]
        extracted_features=encoder(imgs)
        # decoder_hidden : 이미지 feature.
        # extracted_features : [64, 1024] ->  decoder_hidden: [1, 64, 1024]
        decoder_hidden=torch.reshape(extracted_features,(1,extracted_features.shape[0],-1))

        # caption이랑, 이미지 feature가 들어감.
        yhats, decoder_hidden = decoder(caption[:,0:-1],decoder_hidden)

        # gt는 caption에서 첫번째 단어를 제외한 것. [64, 74]
        gt=caption[:,1:]

        # ([64, 74, 8446])-> [4736, 8446] 
        yhats_reshaped=yhats.view(-1,yhats.shape[-1])

        # [64, 74] -> [64*74] = [4736]
        gt=gt.reshape(-1)

        # NLLLoss는 log_softmax를 적용한 후, negative log likelihood loss를 계산함.
        # yhats_reshaped = [4736, 8446] , gt = [4736]
        loss=loss_fn(yhats_reshaped,gt)
        track_loss+=loss.item()

        opte.zero_grad()
        optd.zero_grad()
        
        loss.backward()
        
        opte.step()
        optd.step()

        if not os.path.exists('state_dict'):
            os.makedirs('state_dict')        

        encoder_path = f"state_dict/encoder_epoch_{epoch}.pt"
        decoder_path = f"state_dict/decoder_epoch_{epoch}.pt"

        torch.save(encoder.state_dict(), encoder_path)
        torch.save(decoder.state_dict(), decoder_path)        

        if idx%50==0:
            print("Mini Batch=", idx+1," Running Loss=",track_loss/(idx+1), sep="")
        
    return track_loss/len(train_dataloader)

# 단어의 id를 문장으로 변환하는 함수.
def ids2Sentence(ids,vocab):
    sentence=""
    for id in ids.squeeze():
        if id==0:  # id=0은 SOS이므로, continue
            continue
        word=vocab.index2word[id.item()]
        sentence+=word + " "
        if id==1:  # id=1은 EOS이므로, break
            break
    return sentence

#eval loop (written assuming batch_size=1)
def eval_one_epoch():
    encoder.eval()
    decoder.eval()
    track_loss=0

    with torch.no_grad():
        for i, (imgs,t_ids) in enumerate(test_dataloader):

            imgs=imgs.to(device)
            t_ids=t_ids.to(device)
            # t_ids size : torch.Size([1, 75])
            # imgs size : torch.Size([1, 3, 224, 224])
            print(t_ids.size())
            # extracted_features = [1, 1024]
            extracted_features=encoder(imgs)
            # extracted_features = [1, 1024] -> decoder_hidden = [1, 1, 1024]
            decoder_hidden=torch.reshape(extracted_features,(1,extracted_features.shape[0],-1)) 
            # print(decoder_hidden.size())
            # 배치 사이즈의 모든 행들 중에 첫번째 열만 가져옴.
            input_ids=t_ids[:,0] # SOS 추출. # input_ids.size() : torch.Size([1])
            # print('1. ',input_ids.size())
            yhats=[]
            pred_sentence=""

            for j in range(1, max_cap_length+1): # j start from 1 because 0th token is SOS token
                probs, decoder_hidden = decoder(input_ids.unsqueeze(0),decoder_hidden)
                yhats.append(probs)
                _,input_ids=torch.topk(probs,1, dim=-1)
                # print('2',input_ids.size()) # [1, 1, 1]
                input_ids=input_ids.squeeze(1)
                input_ids=input_ids.squeeze(1)
                word=vocab.index2word[input_ids.item()]
                pred_sentence+=word+" "
                if input_ids.item()==1: # batch_size=1 , 1=EOS (End of Sentence token)
                    break
     
            # t_ids = 길이가 75인 index값으로 구성된 리스트(리스트 길이 75).
            gt_sentence=ids2Sentence(t_ids,vocab)
            
            print("Input Image:")
            img=imgs[0]
            img[0]=(img[0]*0.229)+0.485
            img[1]=(img[1]*0.224)+0.456
            img[2]=(img[2]*0.225)+0.406
            plt.imshow(torch.permute(imgs[0],(1,2,0)).detach().cpu())
            plt.show()
            
            print("GT Sentence:",gt_sentence)
            
            print("Predicted Sentence:",pred_sentence)
            
            yhats_cat=torch.cat(yhats,dim=1)
            yhats_reshaped=yhats_cat.view(-1,yhats_cat.shape[-1])
            gt=t_ids[:,1:j+1]
            gt=gt.view(-1)
            

            loss=loss_fn(yhats_reshaped,gt)
            track_loss+=loss.item()
            
            
        print("-----------------------------------")
        return track_loss/len(test_dataloader)
    
loss_fn=nn.NLLLoss(ignore_index=0).to(device)
lr=0.001

optd=optim.Adam(params=decoder.parameters(), lr=lr)
opte=optim.Adam(params=encoder.parameters(), lr=lr)

n_epochs=1

for e in range(n_epochs):
    print("Epoch=",e+1, " Loss=", round(train_one_epoch(e),4), sep="")

for e in range(1):
    print("Epoch=",e+1, " Loss=", round(eval_one_epoch(),4), sep="")