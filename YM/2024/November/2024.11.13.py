#백준 2747 피보나치 수
import sys
input = sys.stdin.readline

n = int(input())

dp = [0] * (n + 2)
dp[1] = 0
dp[2] = 1

for i in range(3, n + 2):
    dp[i] = dp[i - 1] + dp[i - 2]

print(dp[-1])