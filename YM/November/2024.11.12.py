#백준 2217 로프
import sys
input = sys.stdin.readline

N = int(input())

ropes = []
for _ in range(N):
    ropes.append(int(input()))
ropes.sort()

results = []
for i in ropes:
    results.append(i * N)
    N -= 1

print(max(results))