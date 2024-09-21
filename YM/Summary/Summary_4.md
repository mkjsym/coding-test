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
### 백준 

1. 문제 설명:

    

2. 풀이 방법:

    

3. 코드:
```python

```
***