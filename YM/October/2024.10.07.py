#백준 27433 팩토리얼 2
import sys

def fac(num):
    if (num <= 1):
        return 1
    else:
        return num * fac(num - 1)

N = int(sys.stdin.readline())

print(fac(N))