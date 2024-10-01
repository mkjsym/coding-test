#백준 11050 이항 계수 1
import sys

def fac(a):
    temp = 1

    for i in range(1, a + 1):
        temp *= i

    return temp

N, K = map(int, sys.stdin.readline().split())

print(fac(N) // (fac(N - K) * fac(K)))