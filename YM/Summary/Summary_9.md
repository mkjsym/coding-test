### 백준 2309 일곱 난쟁이

1. 문제 설명:

    왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.

    아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.

    아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

2. 풀이 방법:

    9명의 난쟁이들의 키를 입력받은 뒤 정렬한다. 정렬된 난쟁이들을 이중 반복문을 사용하여 둘 씩 제거할 수 있는 경우를 모두 검사한다. 만약 두 명의 난쟁이를 제거하였을 때 키의 합이 100이라면 결과로 저장한다.

3. 코드:
```python
import sys
input = sys.stdin.readline

nanjaengs = []

for _ in range(9):
    nanjaengs.append(int(input()))

nanjaengs.sort()
total = sum(nanjaengs)
result = []
for i in range(9):
    for j in range(i + 1, 9):
        if (total - nanjaengs[i] - nanjaengs[j]) == 100:
            result.append(nanjaengs[i])
            result.append(nanjaengs[j])
            break
    if (len(result) >= 2):
        break

for i in nanjaengs:
    if i not in result:
        print(i)
```
***
### 백준 2167 2차원 배열의 합

1. 문제 설명:

    2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오. 배열의 (i, j) 위치는 i행 j열을 나타낸다.

2. 풀이 방법:

    Dynamic Programming 기법을 사용하여야 해결할 수 있는 문제. 동적 계획법을 사용하지 않고 단순 반복문으로 코드를 구현하였을 때는 시간 초과가 발생한다.

3. 코드:
```python
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

#시간초과가 떴던 코드...
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
```
***