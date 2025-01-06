### 백준 2941 크로아티아 알파벳

1. 문제 설명: 
    
    문자열에서 특정 문자를 다른 문자로 대체하는 문제

2. 풀이 방법: 
    
    대체해야할 문자의 길이가 2 이상인 경우가 있다. 
    따라서 문자열을 index 단위로 순회하며 다른 문자로 교체를 하는 방식에는 한계가 있다.
    파이썬 문자열 기본 내장 함수인 .replace(대상 문자열 s, 교체할 문자열 "s")를 활용하여 해결하였다.

3. 코드:
```python
trans_list = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]

S = input()

for i in trans_list:
    S = S.replace(i, "*")

print(len(S))
```
***
### 백준 10798 세로읽기

1. 문제 설명:

    2차원 배열 형태로 입력된 문자열들을 세로로 읽어서 출력하는 문제

2. 풀이 방법:

    for 열:
        for 행:
    구조로 반복을 수행.
    열의 반복자 i보다 문자열의 길이가 더 길경우 행렬[j][i] 출력.

3. 코드:
```python
matrix = []

for i in range(5):
    matrix.append(input())

result = []
for i in range(15):
    for j in range(5):
        if (i < len(matrix[j])):
            result.append(matrix[j][i])

for i in result:
    print(i, end="")
```
***
### 백준 11005 진법 변환 2

1. 문제 설명:

    10진법 수 N을 B진법으로 바꿔 출력하는 문제

2. 풀이 방법:

    입력받은 N에 대하여 B의 0승, B의 1승, B의 2승, ... 순으로 나눈 나머지를 계속하여 빼준다. -> B진법 수의 LSB부터 구함
    N에 대하여 위에서 구한 나머지를 빼준다.
    다시 N에 대하여 B의 i승으로 나누어 나머지를 구한다. -> 반복
    digits 리스트에 해당 값(0\~35, 0\~Z)의 문자를 저장한다.
    digits 리스트를 reverse 한다. -> LSB부터 구하여 리스트에 append 하였기 때문. (digits = digits[::-1])

3. 코드:
```python
def returnDigit(A):
    A = int(A)
    if (A >= 0 and A <= 9):
        return chr(ord('0')+A)
    elif (A >= 10 and A <= 35):
        return chr(A+55)

N, B = map(int, input().split())

digits = []
i = 1
while(N > 0):
    iter = N % (B ** i)
    digits.append(returnDigit(iter / (B ** (i - 1))))
    N = N - (iter)
    i += 1

digits = digits[::-1]
for i in range(len(digits)):
    print(digits[i], end="")
```
***
### 백준 9506 약수들의 합

1. 문제 설명:

    어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.
    예를들어 6은 6 = 1 + 2 + 3 이므로 완전수이다.
    n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.

2. 풀이 방법:

    enumerate(열거형)을 사용하여 반복.
    enumerate: 반복 가능한 자료형의 index, index 번째 원소를 리턴

3. 코드:
```python
results = []
while (1):
    n = int(input())
    if (n == -1):
        break

    temp = []
    i = 1
    while (i < n):
        if ((n % i) == 0):
            temp.append(i)
        i += 1
    
    sum = 0
    for j in temp:
        sum += j

    if (n == sum):
        result = str(n) + ' = '
        for index, j in enumerate(temp):
            if (index + 1 == len(temp)):
                result += str(j)
            else:
                result += str(j) + ' + '
        results.append(result)
    else:
        results.append(str(n) + ' is NOT perfect.')

for i in results:
    print(i)
```
***
### 백준 24267 알고리즘 수업 - 알고리즘의 수행 시간 6

1. 문제 설명: 

    ```
    MenOfPassion(A[], n) {
    sum <- 0;
    for i <- 1 to n - 2
        for j <- i + 1 to n - 1
            for k <- j + 1 to n
                sum <- sum + A[i] × A[j] × A[k]; # 코드1
    return sum;
    }
    ```
    위 알고리즘의 시간복잡도를 구하여 출력하는 문제

2. 풀이 방법:

    3중 for문으로 구성된 함수의 시간 복잡도를 구하는 문제.
    다중 시그마 공식을 사용하여 풀어야 한다.
    3개의 반복문 식(시그마)을 간단히 하면 -> n * (n - 1) * (n - 2) / 6

3. 코드:
```python
n = int(input())

result = n * (n - 1) * (n - 2) // 6

print(result)
print(3)
```
***
### 백준 24313 알고리즘 수업 - 점근적 표기 1

1. 문제 설명:

    O(g(n)) = {f(n) | 모든 n ≥ n0에 대하여 f(n) ≤ c × g(n)인 양의 상수 c와 n0가 존재한다}
    위와 같은 시간 복잡도 표기법(빅 오 표기법)이 존재한다고 하자.
    함수 f(n) = a1n + a0, 양의 정수 c, n0가 주어질 경우 O(n) 정의를 만족하는지 알아보자.

2. 풀이 방법:

    단순하게 a1 * n0 + a0 <= c * n0 조건을 검사하여 해결한다.
    그러나 a1과 c의 값이 음수일 경우를 따로 고려해야 한다.
    따라서 a1 * n0 + a0 <= c * n0 조건과 a1 <= c 조건을 and로 묶어 검사하여 답을 출력한다.

3. 코드:
```python
a1, a0 = map(int, input().split())
c = int(input())
n0 = int(input())

if (a1 * n0 + a0 <= c * n0 and a1 <= c):
    print(1)
else:
    print(0)
```
***
### 백준 2798 블랙잭

1. 문제 설명: 

    N장의 카드가 주어졌을 때, M을 넘지 않으면서 M에 가장 가까운 3장의 카드 조합을 찾는 문제

2. 풀이 방법:

    브루트 포스 방식을 사용하여 전수조사하여 답을 찾는다.
    n * (n - 1) * (n - 2)와 같이 반복을 수행하여 중복을 허용하지 않고 3장의 카드를 고르는 모든 경우의 수를 검사한다.
    모든 경우의 수 중에서 M과 같거나 M보다 작은 경우들을 전부 저장한다.
    저장된 값들 중 가장 큰 값을 출력한다.

3. 코드:
```python
N, M = map(int, input().split())
cards = list(map(int, input().split()))

result = 0
for i in range(N):
    for j in range(i + 1, N):
        for k in range(j + 1, N):
            temp = cards[i] + cards[j] + cards[k]

            if (temp <= M):
                result = max(temp, result)

print(result)
```
***
### 백준 2750 수 정렬하기

1. 문제 설명:

    N개의 수가 주어졌을 때 오름차순 정렬하여 출력하는 문제

2. 풀이 방법:

    선택 정렬 알고리즘을 구현하여 해결.
    선택 정렬의 시간 복잡도는 최선, 평균, 최악의 경우 모두 N^2이다.
    효율적이진 않지만 머릿속에 가장 먼저 떠오른 정렬 알고리즘이었다.

3. 코드:
```python
def minNum(numList):
    minNum = numList[0]
    minIndex = 0
    for i in range(1, len(numList)):
        if (minNum > numList[i]):
            minNum = numList[i]
            minIndex = i

    return minIndex

N = int(input())

nums = []
for i in range(N):
    nums.append(int(input()))

for i in range(N):
    idx = minNum(nums[i:])
    temp = nums[i]
    nums[i] = nums[i+idx]
    nums[i+idx] = temp

for i in nums:
    print(i)
```
***
### 백준 1193 분수찾기

1. 문제 설명:

    X가 주어졌을 때 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 X 번째 분수를 찾는 문제

2. 풀이 방법:

    ```python
    while (X > end):
        line += 1
        end += line
    ```
    위와 같이 반복문을 통해 X 번째 수가 속한 line의 위치와 해당 라인의 가장 마지막 원소를 찾는다.
    가장 마지막 원소와 찾고자 하는 값 X의 차를 구하여 해당 라인에서 몇 번째 값을 구해야 하는지 찾는다.
    해당 라인이 홀수 번째 라인인지 짝수 번째 라인인지 검사한 후 결과를 출력한다.

3. 코드:
```python
X = int(input())

end = 0
line = 0
while (X > end):
    line += 1
    end += line

diff = end - X

x = 0
y = 0
if (line % 2 != 0):
    y = line - diff
    x = line + 1 - y
else:
    x = line - diff
    y = line + 1 - x

print(str(x) + '/' + str(y))
```
***
### 백준 7785 회사에 있는사람

1. 문제 설명:

    사람의 이름과 "enter" 혹은 "leave"가 주어질 때, 현재 회사에 남이있는 사람들의 이름을 출력하는 문제

2. 풀이 방법:

    파이썬에서 데이터 집합에 값을 추가할 때 list.append()를 사용하는 것 보다
    set.add()를 사용하는 것이 속도가 더 빠르다.
    정렬 함수는 리스트와 셋 모두 .sort()를 사용할 수 있다.

3. 코드:
```python
N = int(input())

chars = set()
for i in range(N):
    name, stat = map(str, input().split())
    if (stat == 'enter'):
        chars.add(name)
    else:
        chars.remove(name)

chars = list(chars)
chars.sort(reverse = True)

for i in chars:
    print(i)
```
***
### 백준 2751 수 정렬하기 2

1. 문제 설명:

    수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어질 때 이를 오름차순 정렬하여 출력하는 문제
    메모리 제한은 까다롭지 않으나 수행 시간의 제한이 2초.
    값의 중복은 없다.

2. 풀이 방법:

    먼저 키보드 입력을 받을 때 input() 함수를 사용하지 않고 sys 라이브러리를 import 하여 sys.stdin.readline() 함수를 사용한다. -> 시간 단축
    입력값의 중복이 없다고 하였으니 set 자료형을 사용하여 값을 저장한다. -> 시간 단축
    set.sort() 함수를 사용하여 Tim Sort 알고리즘으로 정렬을 수행한다.

3. 코드:
```python
import sys

N = int(input())

nums = set()
for _ in range(N):
    nums.add(int(sys.stdin.readline()))

nums = list(nums)
nums.sort()

for i in nums:
    print(i)
```
***
### 백준 10989 수 정렬하기 3

1. 문제 설명:

    수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어질 때 이를 오름차순 정렬하여 출력하는 문제
    수행 시간의 제한이 까다롭지는 않으나 메모리 제한이 8MB이다.
    값의 범위는 10,000보다 작거나 같은 수.

2. 풀이 방법:

    계수 정렬을 구현하여 정렬을 수행.
    처음에 값의 범위 + 1 만큼의 배열 공간을 생성한 뒤, 입력받은 값의 index에 해당하는 배열의 값을 1 증가시킨다.
    배열의 원소 값이 0이 아닌 모든 인덱스들에 대하여 해당 배열의 값(ex. nums[17] = 5 -> 5번 반복)만큼 반복하며 해당 인덱스를 출력.
    정렬된 값을 출력하는 효과를 보인다.

3. 코드:
```python
import sys
N = int(input())

nums = [0] * (10001)

for _ in range(N):
    nums[int(sys.stdin.readline())] += 1

for i in range(len(nums)):
    if (nums[i] != 0):
        for _ in range(nums[i]):
            print(i)
```
***