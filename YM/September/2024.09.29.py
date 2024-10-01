#백준 24723 녹색거탑
import sys

N = int(sys.stdin.readline())

arr = []
for i in range(N + 1):
    temp = [0] * (N + 1)
    arr.append(temp)

for i in range(N + 1):
    for j in range(i + 1):
        if (j == 0 or j == i):
            arr[i][j] = 1
        else:
            arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j]

result = sum(arr[N])
print(result)