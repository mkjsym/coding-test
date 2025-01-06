#백준 24416 알고리즘 수업 - 피보나치 수 1
import sys

def fib(n):
    arr = [0] * n
    cnt = 0

    arr[0] = arr[1] = 1

    for i in range(2, n):
        arr[i] = arr[i - 1] + arr[i - 2]
        cnt += 1

    return arr[n - 1], cnt

n = int(sys.stdin.readline())

result, cnt = fib(n)

print(result, cnt)