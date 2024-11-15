#백준 2167 2차원 배열의 합
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(list(map(int, input().split())))

K = int(input())
dp = [[0] * (M + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, M + 1):
        dp[i][j] = arr[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1]

results = []
for _ in range(K):
    i, j, x, y = map(int, input().split())
    results.append(dp[x][y] - dp[x][j - 1] - dp[i - 1][y] + dp[i - 1][j - 1])

for i in results:
    print(i)

# import sys
# input = sys.stdin.readline

# N, M = map(int, input().split())
# arr = []
# for _ in range(N):
#     arr.append(list(map(int, input().split())))

# K = int(input())
# results = ''
# for _ in range(K):
#     i, j, x, y = map(int, input().split())

#     sum = 0
#     for a in range(i - 1, x):
#         for b in range(j - 1, y):
#             sum += arr[a][b]
#     results += str(sum) + '\n'

# print(results)