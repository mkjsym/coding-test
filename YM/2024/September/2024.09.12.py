#백준 18258 큐 2#################################################
#리스트로 구현한 큐의 경우 시간 초과가 떴다.. 파이썬 Collections 라이브러리에서 제공하는 deque를 사용하여 큐를 구현하여 해결
#collections 라이브러리의 deque에 대해서 더 공부해야 할 것 같다
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

# import sys

# class queue:
#     def __init__(self):
#         self.data = []
#         self.len = -1
    
#     def push(self, a):
#         self.data.append(a)
#         self.len += 1
    
#     def pop(self):
#         if (self.len != -1):
#             print(self.data[0])
#             del self.data[0]
#             self.len -= 1
#         else:
#             print(-1)

#     def size(self):
#         print(self.len + 1)
    
#     def empty(self):
#         if (self.len == -1):
#             print(1)
#         else:
#             print(0)

#     def front(self):
#         if (self.len == -1):
#             print(-1)
#         else:
#             print(self.data[0])
    
#     def back(self):
#         if (self.len == -1):
#             print(-1)
#         else:
#             print(self.data[-1])

#     def callQueue(self, sel, val = 0):
#         if (sel == 'push'):
#             self.push(val)
#         elif (sel == 'pop'):
#             self.pop()
#         elif (sel == 'size'):
#             self.size()
#         elif (sel == 'empty'):
#             self.empty()
#         elif (sel == 'front'):
#             self.front()
#         elif (sel == 'back'):
#             self.back()

# N = int(sys.stdin.readline().strip())

# queue1 = queue()
# for _ in range(N):
#     temp = sys.stdin.readline().strip()

#     if (len(temp.split()) >= 2):
#         sel, val = map(str, temp.split())
#         queue1.callQueue(sel, val)
#     else:
#         queue1.callQueue(temp)