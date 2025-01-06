#프로그래머스 특정한 문자를 대문자로 바꾸기
def solution(my_string, alp):
    answer = ''
    
    for i in range(len(my_string)):
        if (my_string[i] == alp):
            answer += alp.upper()
        else:
            answer += my_string[i]
    
    return answer

#프로그래머스 A 강조하기
def solution(myString):
    answer = ''
    
    for i in range(len(myString)):
        if (myString[i].lower() == 'a'):
            answer += myString[i].upper()
        else:
            answer += myString[i].lower()
    
    return answer