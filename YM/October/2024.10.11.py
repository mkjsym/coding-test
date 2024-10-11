#백준 15649 N과 M (1)##############################
#dfs 깊이우선탐색을 공부하자
#문자열.join() 함수의 동작 원리를 공부하자
import sys

N, M = map(int, sys.stdin.readline().split())

s = []

def dfs():
    if len(s) == M:
        print(' '.join(map(str, s)))
        return
    
    for i in range(1, N + 1):
        if i not in s:
            s.append(i)
            dfs()
            s.pop()

dfs()