### 백준 1934 최소공배수

1. 문제 설명:

    두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오

2. 풀이 방법:

    유클리드 호제법을 사용하여 최대공약수를 리턴하는 함수를 작성. A와 B의 최대 공약수를 구한 다음 A와 B의 곱에 대하여 나눠주면 최소공배수가 나온다.

3. 코드:
```python
import sys

#유클리드 호제법에 대하여... 자세히 공부해야겠다.
def returnGCM(a, b):
    while (b != 0):
        r = a % b
        a = b
        b = r
    
    return a

T = int(sys.stdin.readline())

results = []
for _ in range(T):
    a, b = map(int, sys.stdin.readline().strip().split())

    results.append((a * b) // returnGCM(a, b))

for i in results:
    print(i)
```
***
### 백준 2485 가로수

1. 문제 설명:

    심어져 있는 가로수의 위치가 주어질 때, 모든 가로수가 같은 간격이 되도록 새로 심어야 하는 가로수의 최소수를 구하는 프로그램을 작성하라. 단, 추가되는 나무는 기존의 나무들 사이에만 심을 수 있다

2. 풀이 방법:

    심어져 있는 가로수들간의 간격을 계산해서 리스트에 저장. 가로수들간의 간격들에 대한 최대공약수를 구한다. 한 간격당 추가적으로 심어주어야 하는 가로수의 수를 result에 더해준다.

3. 코드:
```python
#유클리드 호제법과 math 라이브러리의 gcd 함수를 공부하자.
#바쁘다고 이 문제는 너무 대충 보고 넘어갔으니 반드시 제대로 복습할 것.
import sys
from math import gcd

N = int(sys.stdin.readline())

garosu = []
a = int(sys.stdin.readline())
for i in range(1, N):
    num = int(sys.stdin.readline())
    garosu.append(num - a)
    a = num

g = garosu[0]
for i in garosu[1:]:
    g = gcd(g, i)

result = 0
for i in garosu:
    result += i // g - 1

print(result)
```
***
### 백준 11866 요세푸스 문제 0

1. 문제 설명:

    요세푸스 문제는 다음과 같다.
    
    1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

    N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시

2. 풀이 방법:

    deque 자료형의 .rotate() 함수를 사용하여 원형 큐를 구현한다. 원형 큐를 이용할 수 있다면 요세푸스 순열을 쉽게 구할 수 있다.

3. 코드:
```python
#deque의 rotate() 함수를 사용해 원형 큐를 구현하는 효과를 얻었다.
#deque의 내장함수들을 공부하자. deque는 사기다
import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

deque1 = deque([])
for i in range(N):
    deque1.append(i+1)

yos = []
for i in range(N):
    deque1.rotate(-(K-1))
    yos.append(deque1.popleft())

result = '<' + str(yos[0])
for i in yos[1:]:
    result += ', ' + str(i)
result += '>'

print(result)
```
***
### 백준 4134 다음 소수

1. 문제 설명:

    정수 n(0 ≤ n ≤ 4*109)가 주어졌을 때, n보다 크거나 같은 소수 중 가장 작은 소수 찾는 프로그램을 작성하시오.

2. 풀이 방법:

    소수 판별 함수를 이용해 n부터 n+1, n+2, ... 순으로 소수가 나올 때까지 소수인지 검사한다. 중요한 점은 소수 판별 알고리즘에서 시간 복잡도가 O(루트 N)인 알고리즘을 적용하는 것. i = 2부터 i * i <= num일 때까지를 검사하면 구현할 수 있다.

3. 코드:
```python
#소수 판별 알고리즘을 다시 공부하자. 루트 N의 시간복잡도를 갖는 소수 판별 알고리즘
#테스트 케이스가 0 혹은 1일 때의 예외 처리를 빠트려서 처음에 오답이 됐었다. 정신 차려야지
import sys

n = int(sys.stdin.readline())

def isPrime(num):
    i = 2
    while (i * i <= num):
        if (num % i == 0):
            return False

        i += 1

    return True

results = []
for _ in range(n):
    test_case = int(sys.stdin.readline())
    
    temp = test_case
    while (True):
        if (temp < 2):
            results.append(2)
            break
        elif (isPrime(temp)):
            results.append(temp)
            break
        temp += 1

for i in results:
    print(i)
```
***
### 백준 4948 베르트랑 공준

1. 문제 설명:

    자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.

2. 풀이 방법:

    n이 123,456까지 주어진다는 점을 주목. 리스트를 이용해 1부터 123,456까지 소수인지 여부를 저장. n이 입력되면 n~2n 범위에 소수가 몇 개 있는지 계산한 후 출력.
    미리 소수인지 여부를 저장해 놓은 리스트를 사용하지 않으면 시간초과가 뜬다

3. 코드:
```python
import sys

def isPrime(num):
    if (num < 2):
        return False
    
    i = 2
    while (i * i <= num):
        if (num % i == 0):
            return False
        
        i += 1

    return True

sosu = [1] * (123456 * 2)

for i in range(len(sosu)):
    if (isPrime(i+1)):
        sosu[i] = 1
    else:
        sosu[i] = 0

results = []
while (True):
    n = int(sys.stdin.readline())

    if (n == 0):
        break

    results.append(sum(sosu[n:n * 2]))

for i in results:
    print(i)

#이렇게 하니까 시간 초과가 뜬다. 아무래도 n이 123,456까지인 범위를 이용해서 미리 소수 리스트를 만들어 놓는 방법으로 다시 풀어 보아야겠다.
# import sys

# def isPrime(num):
#     if (num < 2):
#         return False
    
#     i = 2
#     while (i * i <= num):
#         if (num % i == 0):
#             return False
        
#         i += 1

#     return True

# results = []
# while (True):
#     n = int(sys.stdin.readline())

#     if (n == 0):
#         break

#     cnt = 0
#     for i in range(n + 1, 2 * n + 1):
#         if (isPrime(i)):
#             cnt += 1

#     results.append(cnt)

# for i in results:
#     print(i)
```
***
### 백준 13909 창문 닫기

1. 문제 설명:

    서강대학교 컴퓨터공학과 실습실 R912호에는 현재 N개의 창문이 있고 또 N명의 사람이 있다. 1번째 사람은 1의 배수 번째 창문을 열려 있으면 닫고 닫혀 있으면 연다.  2번째 사람은 2의 배수 번째 창문을 열려 있으면 닫고 닫혀 있으면 연다. 이러한 행동을 N번째 사람까지 진행한 후 열려 있는 창문의 개수를 구하라. 단, 처음에 모든 창문은 닫혀 있다.

    예를 들어 현재 3개의 창문이 있고 3명의 사람이 있을 때,
    1번째 사람은 1의 배수인 1,2,3번 창문을 연다. (1, 1, 1)
    2번째 사람은 2의 배수인 2번 창문을 닫는다. (1, 0, 1)
    3번째 사람은 3의 배수인 3번 창문을 닫는다. (1, 0, 0)
    결과적으로 마지막에 열려 있는 창문의 개수는 1개 이다.

2. 풀이 방법:

    솔직히 잘 모르겠는데 아주 간단한 수식을 통해 해결할 수 있는 문제였다..
    기가맥힌 풀이를 정리해 놓은 블로그 링크 -> https://parade621.tistory.com/56

3. 코드:
```python
#N 이하의 제곱수의 개수를 구하면 풀 수 있는 문제...
import sys

N = int(sys.stdin.readline())

print(int(N**0.5))
```
***
### 백준 17103 골드바흐 파티션

1. 문제 설명:

    골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
    
    짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다. 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자. 두 소수의 순서만 다른 것은 같은 파티션이다.

2. 풀이 방법:

    N의 범위 1~1,000,000의 수들이 소수인지 여부를 저장해 놓는 리스트(에라토스테네스의 체) 생성. 골드바흐 파티션의 개수를 체크하여 출력한다.

3. 코드:
```python
#왤케 어려워 이거
#에라토스테네스의 체인지 에라이모르겠다 체인지에 대해서 공부하자.. 특정 범위까지 모든 소수를 찾아내는 데에 유용한 알고리즘이라고 한다
import sys

primes = []
check = [1, 1] + [0] * 999999

for i in range(2, 1000001):
    if (check[i] == 0):
        primes.append(i)
        for j in range(2*i, 1000001, i):
            check[j] = 1

T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())

    count = 0
    for j in primes:
        if (j >= N):
            break
        if ((not check[N - j]) and (j <= N - j)):
            count += 1

    print(count)
```
***
### 백준 2346 풍선 터뜨리기

1. 문제 설명:

    1번부터 N번까지 N개의 풍선이 원형으로 놓여 있고. i번 풍선의 오른쪽에는 i+1번 풍선이 있고, 왼쪽에는 i-1번 풍선이 있다. 단, 1번 풍선의 왼쪽에 N번 풍선이 있고, N번 풍선의 오른쪽에 1번 풍선이 있다. 각 풍선 안에는 종이가 하나 들어있고, 종이에는 -N보다 크거나 같고, N보다 작거나 같은 정수가 하나 적혀있다. 이 풍선들을 다음과 같은 규칙으로 터뜨린다.

    우선, 제일 처음에는 1번 풍선을 터뜨린다. 다음에는 풍선 안에 있는 종이를 꺼내어 그 종이에 적혀있는 값만큼 이동하여 다음 풍선을 터뜨린다. 양수가 적혀 있을 경우에는 오른쪽으로, 음수가 적혀 있을 때는 왼쪽으로 이동한다. 이동할 때에는 이미 터진 풍선은 빼고 이동한다.

    예를 들어 다섯 개의 풍선 안에 차례로 3, 2, 1, -3, -1이 적혀 있었다고 하자. 이 경우 3이 적혀 있는 1번 풍선, -3이 적혀 있는 4번 풍선, -1이 적혀 있는 5번 풍선, 1이 적혀 있는 3번 풍선, 2가 적혀 있는 2번 풍선의 순서대로 터지게 된다.

2. 풀이 방법:

    deque 자료형을 사용하여 원형 큐를 구현하여 문제를 해결할 수 있다. 원형 큐 구현 과정에서 deque.rotate() 함수의 작동 방향에 주의하여 코드를 작성하자

3. 코드:
```python
#.rotate() 함수의 작동 방향에 유의해야 할 것 같다. 처음에 반대로 했다가 틀림
import sys
from collections import deque

N = int(sys.stdin.readline())
deque1 = deque(map(int, sys.stdin.readline().split()))
deque2 = deque([])

for i in range(len(deque1)):
    deque2.append(i + 1)

results = []
temp = deque1.popleft()
res = deque2.popleft()
results.append(res)
while (len(deque1) > 0):
    deque1.rotate(1 - temp if temp > 0 else -temp)
    deque2.rotate(1 - temp if temp > 0 else -temp)
    temp = deque1.popleft()
    res = deque2.popleft()
    results.append(res)

for i in results:
    print(i, end = ' ')
```
***