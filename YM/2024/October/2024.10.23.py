#백준 9461 파도반 수열
import sys
input = sys.stdin.readline

dp = [0] * 101
dp[1] = 1
dp[2] = 1
dp[3] = 1

def P(num):
    if (dp[num]):
        return dp[num]
    else:
        dp[num] = P(num - 2) + P(num - 3)
        return dp[num]

T = int(input())

for _ in range(T):
    N = int(input())

    print(P(N))
