### 백준 24060 알고리즘 수업 - 병합 정렬 1

1. 문제 설명:

    오늘도 서준이는 병합 정렬 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.

    N개의 서로 다른 양의 정수가 저장된 배열 A가 있다. 병합 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 저장되는 수를 구해서 우리 서준이를 도와주자.

2. 풀이 방법:

    배열을 이용하여 병합정렬 알고리즘을 구현한다. 전역변수 cnt를 사용하여 출력 리스트에 값이 추가될 때마다 카운트 값을 1씩 증가시킨다. cnt의 값이 K와 같아질 경우 해당 인덱스를 전역변수 result에 저장.

3. 코드:
```python
#정렬 알고리즘 자체는 어렵지 않게 구현할 수 있었으나, 문제에서 요구하는 답을 출력하도록 만드는 것이 어려웠음
import sys

def merge_sort(arr, s, e):
    if (s < e):
        mid = (s + e) // 2
        merge_sort(arr, s, mid)
        merge_sort(arr, mid + 1, e)
        merge(arr, s, mid, e)

def merge(arr, s, mid, e):
    global cnt, result
    i = s
    j = mid + 1
    temp = []

    while (i <= mid and j <= e):
        if (arr[i] <= arr[j]):
            temp.append(arr[i])
            i += 1
        else:
            temp.append(arr[j])
            j += 1

    while (i <= mid):
        temp.append(arr[i])
        i += 1
    while (j <= e):
        temp.append(arr[j])
        j += 1
    
    i = s
    t = 0
    while (i <= e):
        arr[i] = temp[t]
        cnt += 1
        if cnt == K:
            result = arr[i]
            break
        i += 1
        t += 1

N, K = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

cnt = 0
result = -1
merge_sort(arr, 0, len(arr) - 1)

print(result)
```
***
### 백준 9184 신나는 함수 실행

1. 문제 설명:

    다음과 같은 재귀함수 w(a, b, c)가 있다.

    if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns:
        1

    if a > 20 or b > 20 or c > 20, then w(a, b, c) returns:
        w(20, 20, 20)

    if a < b and b < c, then w(a, b, c) returns:
        w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)

    otherwise it returns:
        w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    위의 함수를 구현하는 것은 매우 쉽다. 하지만, 그대로 구현하면 값을 구하는데 매우 오랜 시간이 걸린다. (예를 들면, a=15, b=15, c=15)

    a, b, c가 주어졌을 때, w(a, b, c)를 출력하는 프로그램을 작성하시오.

2. 풀이 방법:

    동적 계획법을 사용하여 해결할 수 있는 문제. 동적 계획법에 대하여 제대로 이해하고 있다면 해결할 수 있다.

3. 코드:
```python
import sys

dp = [[[0] * (21) for _ in range(21)] for _ in range(21)]

def w(a, b, c):
    if (a <= 0 or b <= 0 or c <= 0):
        return 1
    elif (a > 20 or b > 20 or c > 20):
        return w(20, 20, 20)
    
    if dp[a][b][c]:
        return dp[a][b][c]
    
    if (a < b < c):
        dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
        return dp[a][b][c]
    else:
        dp[a][b][c] =  w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)
        return dp[a][b][c]
    
while (True):
    a, b, c = map(int, sys.stdin.readline().split())

    if (a == b == c == -1):
        break

    print(f'w({a}, {b}, {c}) = {w(a, b, c)}')
```
***
### 백준 1904 01타일

1. 문제 설명:

    지원이에게 2진 수열을 가르쳐 주기 위해, 지원이 아버지는 그에게 타일들을 선물해주셨다. 그리고 이 각각의 타일들은 0 또는 1이 쓰여 있는 낱장의 타일들이다.

    어느 날 짓궂은 동주가 지원이의 공부를 방해하기 위해 0이 쓰여진 낱장의 타일들을 붙여서 한 쌍으로 이루어진 00 타일들을 만들었다. 결국 현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일들만이 남게 되었다.

    그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다. 예를 들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다. (01, 10은 만들 수 없게 되었다.) 또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.

    우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다. 단 타일들은 무한히 많은 것으로 가정하자.

2. 풀이 방법:

    동적 계획법을 사용하여 해결할 수 있는 문제. 연산 결과가 정수형 범위를 벗어나기 때문에 나머지 연산을 매 연산마다 적용하여야 한다.

3. 코드:
```python
import sys
input = sys.stdin.readline

dp = [0] * 1000001
dp[1] = 1
dp[2] = 2

N = int(input())

for i in range(3, N + 1):
    dp[i] = (dp[i - 1] + dp[i - 2]) % 15746

print(dp[N])
```
***
### 백준 15650 N과 M (2)

1. 문제 설명:

    자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

    -  N까지 자연수 중에서 중복 없이 M개를 고른 수열
    
    - 고른 수열은 오름차순이어야 한다.

2. 풀이 방법:

    깊이 우선 탐색을 구현하여 해결할 수 있는 문제. start 변수를 사용하여 dfs의 시작 지점을 설정한다. 시작 지점을 한 칸씩 뒤로 옮기면서 한 수열에서 값의 중복을 방지.    

3. 코드:
```python
import sys
input = sys.stdin.readline

N, M = map(int, input().split())

s = []

def dfs(start):
    if len(s) == M:
        print(' '.join(map(str, s)))
        return
    
    for i in range(start, N + 1):
        if i not in s:
            s.append(i)
            dfs(i + 1)
            s.pop()

dfs(1)
```
***