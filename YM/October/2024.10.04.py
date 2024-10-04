#백준 25192 인사성 밝은 곰곰이
import sys

N = int(sys.stdin.readline())

cnt = 0
chats = set()
for _ in range(N):
    temp = sys.stdin.readline().strip()

    if (temp == 'ENTER'):
        chats = set()
        continue
    
    if (temp in chats):
        continue

    cnt += 1
    chats.add(temp)

print(cnt)