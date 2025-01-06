#백준 1065 한수
import sys
input = sys.stdin.readline

def isHansu(n):
    first = n % 10
    n = n // 10
    diff = first - n % 10
    before = n % 10
    n = n // 10
    while(n != 0):
        if (before - n % 10 == diff):
            before = n % 10
            n = n // 10
        else:
            return False
        
    return True

N = int(input())
cnt = 0
for i in range(1, N + 1):
    if (isHansu(i)):
        cnt += 1

print(cnt)