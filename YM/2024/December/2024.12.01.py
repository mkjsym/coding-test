#백준 1158 요세푸스 문제
import sys
input = sys.stdin.readline

from collections import deque

dq = deque([])
N, K = map(int, input().split())

for i in range(1, N + 1):
    dq.append(i)

result = '<'
for i in range(N):
    dq.rotate(-(K-1))
    if (i == N - 1):
        result += str(dq.popleft()) + '>'
    else:
        result += str(dq.popleft()) + ', '

print(result)