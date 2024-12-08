#백준 17608 막대기
import sys
input = sys.stdin.readline

N = int(input())

bars = []
for _ in range(N):
    bars.append(int(input()))

cnt = 1
max = bars[-1]
for i in range(2, N + 1):
    if (bars[-i] > max):
        cnt += 1
        max = bars[-i]

print(cnt)