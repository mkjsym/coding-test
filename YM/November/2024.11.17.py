#백준 14501 퇴사####################################################
#동적 계획법을 사용하여서 풀어야 하는 문제.
import sys
input = sys.stdin.readline

N = int(input())

table = []
for _ in range(N):
    table.append(list(map(int, input().split())))

dp = [0 for i in range(N + 1)]

for i in range(N):
    for j in range(i + table[i][0], N + 1):
        if (dp[j] < dp[i] + table[i][1]):
            dp[j] = dp[i] + table[i][1]

print(dp[-1])