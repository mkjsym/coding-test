### collections.Deque

* Deque란?
    파이썬 collections 라이브러리에 포함되어 있는 Deque 클래스.

    리스트 자료형과 유사한 구조.

    리스트보다 속도가 빠르다.

    popleft(), appendleft() 등의 함수를 지원한다.

***
### 백준 18870 좌표 압축

1. 문제 설명:

    수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.

    Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.

    X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

2. 풀이 방법:

    먼저 입력 숫자들을 한 줄로 입력받아 리스트에 저장. 리스트를 set()으로 만들어 따로 저장해 둠. 입력 set()을 정렬해준 뒤 딕셔너리를 이용하여 key=값, value=index로 저장해줌. 처음에 입력 받았던 리스트를 순회하며 dic[값] 꼴로 호출하여 출력. -> 상대적인 인덱스가 출력됨.

3. 코드:
```python
import sys

N = int(sys.stdin.readline().strip())
nums = list(map(int, sys.stdin.readline().strip().split()))
nums_set = set(nums)
nums_set = sorted(nums_set)

dic = {}
for i in range(len(nums_set)):
    dic[nums_set[i]] = i

for i in nums:
    print(dic[i], end = " ")
print()
```
***
### 백준 18258 큐 2

1. 문제 설명:

    큐를 구현하는 문제. push, pop, size, empty, front, back, callQueue 등의 함수를 포함.

2. 풀이 방법:

    collections 라이브러리에서 Deque를 import하여 구현. 리스트를 이용하여 구현할 경우 시간 초과.

3. 코드:
```python
import sys
from collections import deque

class queue:
    def __init__(self):
        self.dq = deque([])
        self.len = -1
    
    def push(self, a):
        self.dq.append(a)
        self.len += 1
    
    def pop(self):
        if (self.len != -1):
            temp = self.dq.popleft()
            print(temp)
            self.len -= 1
        else:
            print(-1)

    def size(self):
        print(self.len + 1)
    
    def empty(self):
        if (self.len == -1):
            print(1)
        else:
            print(0)

    def front(self):
        if (self.len == -1):
            print(-1)
        else:
            print(self.dq[0])
    
    def back(self):
        if (self.len == -1):
            print(-1)
        else:
            print(self.dq[-1])

    def callQueue(self, sel, val = 0):
        if (sel == 'push'):
            self.push(val)
        elif (sel == 'pop'):
            self.pop()
        elif (sel == 'size'):
            self.size()
        elif (sel == 'empty'):
            self.empty()
        elif (sel == 'front'):
            self.front()
        elif (sel == 'back'):
            self.back()

N = int(sys.stdin.readline().strip())

queue1 = queue()
for _ in range(N):
    temp = sys.stdin.readline().strip()

    if (len(temp.split()) >= 2):
        sel, val = map(str, temp.split())
        queue1.callQueue(sel, val)
    else:
        queue1.callQueue(temp)
```
***