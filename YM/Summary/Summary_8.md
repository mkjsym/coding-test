### 백준 1541 잃어버린 괄호

1. 문제 설명:

    

2. 풀이 방법:

    

3. 코드:
```python
import sys
input = sys.stdin.readline

string = input().strip()

nums = string.split('-')

sums = []

for i in nums:
    tmp = list(map(int, i.split('+')))

    sums.append(sum(tmp))

print(sums[0] - sum(sums[1:]))
```
***
### 백준 2579 계단 오르기

1. 문제 설명:

    

2. 풀이 방법:

    

3. 코드:
```python
#백준 2579 계단 오르기##############################################
import sys
input = sys.stdin.readline

N = int(input())

stairs = [0] * 301
for i in range(1, N + 1):
    stairs[i] = int(input())

dp = [0] * 301
dp[1] = stairs[1]
dp[2] = stairs[1] + stairs[2]
dp[3] = max(stairs[1] + stairs[3], stairs[2] + stairs[3])

for i in range(4, N + 1):
    dp[i] = max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i])

print(dp[N])
```
***