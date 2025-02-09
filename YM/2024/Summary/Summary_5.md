### 백준 2108 통계학

1. 문제 설명:

    수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

    산술평균 : N개의 수들의 합을 N으로 나눈 값
    중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
    최빈값 : N개의 수들 중 가장 많이 나타나는 값
    범위 : N개의 수들 중 최댓값과 최솟값의 차이
    
    N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

2. 풀이 방법:

    산술평균은 전체 수의 합을 수의 개수로 나누어 구한다. 중앙값은 전체 수를 정렬한 뒤 전체 수의 개수를 2로 나눈 값의 인덱스를 출력하여 구한다. 문제는 최빈값을 구하는 것. 최빈값은 딕셔너리를 활용하여 값을 입력받을 때 각 값의 개수를 카운트 한 뒤, 카운트 값이 최대인 경우들을 찾고 두 번째로 큰 값을 출력한다(정렬 후 [1]번째 인덱스 출력). 값의 범위는 정렬된 수들 중에서 가장 마지막 값에서 가장 첫 번째 값을 빼주어 구한다.

3. 코드:
```python
#round() 함수의 사용법과 최빈값 구하는 알고리즘을 다시 공부하자
import sys

N = int(sys.stdin.readline())

nums = []
total = 0
counts = dict()
for _ in range(N):
    temp = int(sys.stdin.readline())
    total += temp
    nums.append(temp)
    if (temp not in counts):
        counts[temp] = 1
    else:
        counts[temp] += 1

nums.sort()

one = sum(nums) / len(nums)
two = nums[len(nums) // 2]

freq = max(counts.values())
num = []
for k, v in counts.items():
    if (v == freq):
        num.append(k)
if (len(num) == 1):
    three = num[0]
else:
    three = sorted(num)[1]

four = nums[-1] - nums[0]

print(round(one))
print(two)
print(three)
print(four)
```
***
### 백준 4779 칸토어 집합

1. 문제 설명:

    칸토어 집합은 0과 1사이의 실수로 이루어진 집합으로, 구간 [0, 1]에서 시작해서 각 구간을 3등분하여 가운데 구간을 반복적으로 제외하는 방식으로 만든다.

    전체 집합이 유한이라고 가정하고, 다음과 같은 과정을 통해서 칸토어 집합의 근사를 만들어보자.

    1. -가 3N개 있는 문자열에서 시작한다.

    2. 문자열을 3등분 한 뒤, 가운데 문자열을 공백으로 바꾼다. 이렇게 하면, 선(문자열) 2개가 남는다.

    3. 이제 각 선(문자열)을 3등분 하고, 가운데 문자열을 공백으로 바꾼다. 이 과정은 모든 선의 길이가 1일때 까지 계속 한다.

2. 풀이 방법:

    재귀함수를 구현하여 칸토어 집합을 구할 수 있다. 이 문제를 풀 때 인상적이었던 점은 칸토어 집합을 구현하는 부분이 아니라 테스트 케이스 입력 방식이다. 파일의 끝에서 입력이 끝난다 라는 표현이 사용되었는데, 이러한 경우 try ~ except문을 활용할 수 있다. except 조건에 EOF(End of File)를 사용하거나 특정 예외 조건을 명시하지 않는 방법을 사용할 수 있다.

3. 코드:
```python
#파일의 끝에서 입력이 끝나는 경우가 있다. 이는 try ~ except 문으로 구현 가능
import sys

def cantore(string):
    if (len(string) <= 1):
        return string
    else:
        low = string[:len(string) // 3]
        mid = string[len(string) // 3:(len(string) // 3) * 2]
        high = string[(len(string) // 3) * 2:]

        mid = ' ' * (len(mid))  

        return cantore(low) + mid + cantore(high)

results = []
while True:
    try:
        N = int(sys.stdin.readline())
        init = '-' * (3 ** N)
        results.append(cantore(init))
    except:
        break

for i in results:
    print(i)
```
***
### 백준 15649 N과 M (1)

1. 문제 설명:

    자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

    - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열


2. 풀이 방법:

    DFS(깊이우선탐색) 알고리즘을 사용하면 간단한 코드로 해결할 수 있다. DFS 알고리즘을 공부해야 할 것 같다.. 문자열.join() 함수를 활용하여 정답을 출력한다.

3. 코드:
```python
#dfs 깊이우선탐색을 공부하자
#문자열.join() 함수의 동작 원리를 공부하자
import sys

N, M = map(int, sys.stdin.readline().split())

s = []

def dfs():
    if len(s) == M:
        print(' '.join(map(str, s)))
        return
    
    for i in range(1, N + 1):
        if i not in s:
            s.append(i)
            dfs()
            s.pop()

dfs()
```
***