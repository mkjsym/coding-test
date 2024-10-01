#백준 12789 도키도키 간식드리미
import sys
from collections import deque

N = int(sys.stdin.readline())
queue1 = deque(map(int, sys.stdin.readline().split()))
queue2 = deque([])
head = 1

while (len(queue1) > 0):
    if (queue1[0] == head):
        queue1.popleft()
        head += 1
        continue

    if (len(queue2) > 0):
        if (queue2[-1] == head):
            queue2.pop()
            head += 1
            continue

    queue2.append(queue1.popleft())

sel = True
while (len(queue2) > 0):
    if (queue2[-1] != head):
        sel = False
        break
    else:
        queue2.pop()
        head += 1

if (sel == True):
    print('Nice')
else:
    print('Sad')