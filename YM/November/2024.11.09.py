#백준 1026 보물
import sys
input = sys.stdin.readline

N = int(input())

a = list(map(int, input().split()))
a.sort()
b = list(map(int, input().split()))
b.sort(reverse = True)

print(a, b)

sum = 0
for i in range(N):
    sum += a[i] * b[i]

print(sum)
