#백준 1929 소수 구하기
import sys

def isPrime(num):
    temp = 2
    while (temp * temp <= num):
        if (num % temp == 0):
            return False

        temp += 1

    return True

M, N = map(int, sys.stdin.readline().split())

for i in range(M, N + 1):
    if (i > 1):
        if (isPrime(i)):
            print(i)