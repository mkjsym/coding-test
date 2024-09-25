#백준 12789 도키도키 간식드리미
import sys
from collections import deque

N = int(sys.stdin.readline())
queue1 = deque(map(int, sys.stdin.readline().split()))
queue2 = deque([])
head = 1

while (True):
    if (head in queue1):
        queue2.append(queue1.pop)
    elif (head in queue2):
        queue1.append(queue2.pop)
    else:
        print('Sad')
        break

    if (head == N):
        print('Nice')
        break

    head += 1