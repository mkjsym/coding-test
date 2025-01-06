#백준 2346 풍선 터뜨리기#######################################################
#.rotate() 함수의 작동 방향에 유의해야 할 것 같다. 처음에 반대로 했다가 틀림
import sys
from collections import deque

N = int(sys.stdin.readline())
deque1 = deque(map(int, sys.stdin.readline().split()))
deque2 = deque([])

for i in range(len(deque1)):
    deque2.append(i + 1)

results = []
temp = deque1.popleft()
res = deque2.popleft()
results.append(res)
while (len(deque1) > 0):
    deque1.rotate(1 - temp if temp > 0 else -temp)
    deque2.rotate(1 - temp if temp > 0 else -temp)
    temp = deque1.popleft()
    res = deque2.popleft()
    results.append(res)

for i in results:
    print(i, end = ' ')