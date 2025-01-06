#백준 1010 다리 놓기
import sys

def fac(num):
    temp = 1

    for i in range(1, num + 1):
        temp *= i

    return temp

T = int(sys.stdin.readline())

result = []
for _ in range(T):
    N, M = map(int, sys.stdin.readline().split())
    
    result.append((fac(M)) // (fac(M - N) * fac(N)))

for i in result:
    print(i)