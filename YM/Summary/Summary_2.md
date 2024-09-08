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

    내가 가지고 있는 카드 N장을 입력받을 때 set()으로 입력받아 중복을 제거하여 저장. 제시되는 숫자 카드들은 중복이 허용되니 list()로 입력받은 후 for 반복문을 이용해 순회하며 내가 가지고 있는 카드 set() 안에 존재하는지 검사(in). 만약 존재하면 1을 출력, 존재하지 않으면 0을 출력.

3. 코드:
```python
import sys
N = int(sys.stdin.readline())

리스트로 했을땐 시간초과, set으로 하니까 통과가 됐다..
nums = set(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())

Mnums = list(map(int, sys.stdin.readline().split()))

for i in Mnums:
    if (i in nums):
        print(1, end = ' ')
    else:
        print(0, end = ' ')
```
***
### 백준 1620 나는야 포켓몬 마스터 이다솜

1. 문제 설명:

    도감에 수록되어 있는 포켓몬의 개수 N과 내가 맞춰야 하는 문제 M이 주어질 때 문제가 숫자로 이루어져 있으면 포켓몬의 이름을, 문제가 문자로 이루어져 있으면 도감 번호를 출력해야 하는 문제

2. 풀이 방법:

    딕셔너리 자료형을 창의적으로 이용해서 해결. 하나의 딕셔너리에 dic[i + 1], dic[temp] 두 가지 키로 각각의 value를 등록하여 도감 번호-포켓몬 이름, 포켓몬 이름-도감 번호 두 종류의 데이터를 함께 보관한다. 문제를 입력 받은 뒤 문제가 숫자인지 아닌지(temp.isdigit()) 구분한 뒤 해당하는 키를 이용하여 value를 읽어 출력한다.

3. 코드:
```python
import sys

N, M = map(int, sys.stdin.readline().split())

dic = {}
for i in range(N):
    temp = sys.stdin.readline().strip()
    dic[i + 1] = temp
    dic[temp] = i + 1

result = ""
for _ in range(M):
    temp = sys.stdin.readline().strip()

    if (temp.isdigit()):
        result += dic[int(temp)] + '\n'
    else:
        result += str(dic[temp]) + '\n'

print(result)
```
***
### 백준 1181 단어 정렬

1. 문제 설명:

    알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 문제
    1. 길이가 짧은 것부터
    2. 길이가 같으면 사전 순으로
    단, 중복된 단어는 하나만 남기고 제거해야 한다.

2. 풀이 방법:

    문제에서 중복된 단어는 제거하라고 하였기 때문에 set() 자료형을 사용. sorted() 함수를 사용하여 사전순 정렬을 먼저 수행한 후 단어의 길이순 정렬을 수행. 단어의 길이순 정렬을 하기 위해선 sorted(chars, key = len)과 같이 정렬.

3. 코드:
```python
import sys

N = int(sys.stdin.readline().strip())

#중복된 문자열은 제거하라고 하였기 때문에 set() 자료형을 사용
chars = set()
for _ in range(N):
    chars.add(sys.stdin.readline().strip())

#sort()는 리스트 전용 정렬 함수이며, sorted()는 리스트, 셋, 딕셔너리 모두 정렬이 가능한 정렬함수이다
#정렬 문제의 경우 조건 A, B가 주어질 경우 B 조건, A 조건 순으로 정렬하여야 한다
chars = sorted(chars)
chars = sorted(chars, key = len)

for i in chars:
    print(i)
```
***
### 백준 10816 숫자 카드 2

1. 문제 설명:

    숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 문제

2. 풀이 방법:

    이 문제에선 각각의 입력들에 대하여 중복을 고려하여야 하기 때문에 리스트 자료형으로 값을 저장한다. count 딕셔너리를 이용하여 제시되는 정수가 상근이가 가지고 있는 카드에 존재할 경우 해당 key를 가진 딕셔너리 원소의 value 값을 1 증가시킨다. 만약 해당 정수를 처음 검색한 경우 counts[key] = 1과 같이 딕셔너리 원소를 추가한다. 이후 for 반복문을 통해 딕셔너리 내장함수 .get()을 활용하여 제시된 정수가 count 딕셔너리에 몇개 저장되었는지 호출하고 만약 값이 없어 None이 반환된다면 0을, 정수가 반환된다면 해당 값을 출력한다.

3. 코드:
```python
import sys

N = int(sys.stdin.readline().strip())
have = list(map(int, sys.stdin.readline().strip().split()))

M = int(sys.stdin.readline().strip())
cards = list(map(int, sys.stdin.readline().strip().split()))

counts = {}
for i in have:
    if (i in counts):
        counts[i] += 1
    else:
        counts[i] = 1

for i in cards:
    #딕셔너리 함수 .get()의 사용법을 익혀두자.. 찾고자 하는 key가 존재하지 않을 경우 None을 반환
    result = counts.get(i)
    if (result == None):
        print(0, end = ' ')
    else:
        print(result, end = ' ')
```
***