#백준 1149 RGB 거리##########################################
import sys
input = sys.stdin.readline

N = int(input())

costs = [0] * N
for i in range(N):
    costs[i] = list(map(int, input().split()))

for i in range(1, N):
    costs[i][0] = min(costs[i - 1][1], costs[i - 1][2]) + costs[i][0]
    costs[i][1] = min(costs[i - 1][0], costs[i - 1][2]) + costs[i][1]
    costs[i][2] = min(costs[i - 1][0], costs[i - 1][1]) + costs[i][2]

print(min(costs[N - 1][0], costs[N - 1][1], costs[N - 1][2]))
