#백준 10870 피보나치 수 5
import sys

def fib(num):
    if (num <= 1):
        return num
    else:
        return fib(num - 1) + fib(num - 2)

N = int(sys.stdin.readline())

print(fib(N))