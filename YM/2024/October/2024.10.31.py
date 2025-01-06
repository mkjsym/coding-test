#백준 1931 회의실 배정
import sys
input = sys.stdin.readline

N = int(input())

times = []
for _ in range(N):
    times.append(list(map(int, input().split())))

times.sort(key = lambda x : (x[1], x[0]))

pivot = 0
result = 0
for s, e in times:
    if (pivot <= s):
        result += 1
        pivot = e

print(result)
