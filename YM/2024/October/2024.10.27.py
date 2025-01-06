#백준  11047 동전 0
import sys
input = sys.stdin.readline

N, K = map(int, input().split())

dongjeons = []
for _ in range(N):
    dongjeons.append(int(input()))

cnt = 0
for i in dongjeons[::-1]:
    if (K // i > 0):
        cnt += K // i
        K = K % i

print(cnt)
