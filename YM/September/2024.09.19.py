#백준 11866 요세푸스 문제 0##########################################################
#deque의 rotate() 함수를 사용해 원형 큐를 구현하는 효과를 얻었다.
#deque의 내장함수들을 공부하자. deque는 사기다
import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

deque1 = deque([])
for i in range(N):
    deque1.append(i+1)

yos = []
for i in range(N):
    deque1.rotate(-(K-1))
    yos.append(deque1.popleft())

result = '<' + str(yos[0])
for i in yos[1:]:
    result += ', ' + str(i)
result += '>'

print(result)