### 람다식

* 람다식이란?
    ㅁㄴㅇ

***
### map() 함수

* map() 함수란?
    ㅁㄴㅇ

***
### 백준 11651 좌표 정렬하기 2

1. 문제 설명:

    2차원 평면 위의 점이 N개 주어질 때, X가 증가하는 순으로, X가 같으면 Y가 증가하는 순으로 정렬하는 문제

2. 풀이 방법:

    x 좌표와 y 좌표를 리스트로 묶어서 리스트에 append. 2차원 리스트가 구현됨. 리스트.sort()를 통해 자동으로? x, y좌표 순으로 정렬이 됨.

3. 코드:
```python
import sys

N = int(sys.stdin.readline())

cords = []
for _ in range(N):
    x, y = map(int, sys.stdin.readline().split())

    cords.append([x, y])

cords.sort()

for i in cords:
    print(i[0], i[1])

#아래같은 방법은 시간초과가 떴다.. 왜지?
# result = ""
# for i in cords:
#     result = result + i[0] + ' ' + i[1] + '\n'

# print(result)
```
***
### 백준 11651 좌표 정렬하기 2

1. 문제 설명:

    2차원 평면 위의 점이 N개 주어질 때, Y가 증가하는 순으로, Y가 같으면 X가 증가하는 순으로 정렬하는 문제

2. 풀이 방법:

    x 좌표와 y 좌표를 리스트로 묶어 리스트에 append. 2차원 리스트가 구현됨. sort() 함수의 key를 이용해 람다식을 활용하여 정렬을 수행 => coords.sort(key = lambda x: (x[1], x[0])). 람다식을 공부할 필요가 있어보임.

3. 코드:
```python
import sys

N = int(sys.stdin.readline())

coords = []
for _ in range(N):
    x, y = map(int, sys.stdin.readline().split())
    coords.append([x, y])

key를 활용한 람다식 사용. 파이썬 람다식 사용법을 공부하자
coords.sort(key = lambda x: (x[1], x[0]))

for i in coords:
    print(i[0], i[1])
```
***
### 백준 10815 숫자 카드

1. 문제 설명:

    현재 내가 가지고 있는 카드의 장 수와 숫자가 주어질 때, 제시되는 수의 숫자 카드들을 가지고 있는지 여부를 출력하는 문제

2. 풀이 방법:

    

3. 코드:
```python
```
***
### 백준 1620 나는야 포켓몬 마스터 이다솜

1. 문제 설명:

2. 풀이 방법:

3. 코드:
```python
```
***
### 백준 1181 단어 정렬

1. 문제 설명:

2. 풀이 방법:

3. 코드:
```python
```
***
### 백준 10816 숫자 카드 2

1. 문제 설명:

2. 풀이 방법:

3. 코드:
```python
```
***
### 백준