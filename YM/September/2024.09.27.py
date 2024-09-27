#백준 24511 queuestack
import sys
from collections import deque

N = int(sys.stdin.readline())
qs = list(map(int, sys.stdin.readline().split()))
init = list(map(int, sys.stdin.readline().split()))

queuestack = deque([])
for i in range(N):
    if (qs[i] == 0):
        queuestack.append(init[i])

M = int(sys.stdin.readline())
suyeol = list(map(int, sys.stdin.readline().split()))

results = []
for i in range(M):
    queuestack.appendleft(suyeol[i])
    results.append(queuestack.pop())

for i in results:
    print(i, end = ' ')