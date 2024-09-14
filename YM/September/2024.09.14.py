#백준 28279 덱 2
import sys
from collections import deque

class Deque:
    def __init__(self):
        self.dq = deque([])
        self.len = 0

    def pushfront(self, val):
        self.dq.appendleft(val)
        self.len += 1
    
    def push(self, val):
        self.dq.append(val)
        self.len += 1

    def popleft(self):
        if (self.len > 0):
            print(self.dq.popleft())
            self.len -= 1
        else:
            print(-1)

    def pop(self):
        if (self.len > 0):
            print(self.dq.pop())
            self.len -= 1
        else:
            print(-1)

    def length(self):
        print(self.len)

    def isempty(self):
        if (self.len == 0):
            print(1)
        else:
            print(0)

    def front(self):
        if (self.len > 0):
            print(self.dq[0])
        else:
            print(-1)
    
    def back(self):
        if (self.len > 0):
            print(self.dq[-1])
        else:
            print(-1)

    def callDeque(self, sel, val = 0):
        if (sel == 1):
            self.pushfront(val)
        elif (sel == 2):
            self.push(val)
        elif (sel == 3):
            self.popleft()
        elif (sel == 4):
            self.pop()
        elif (sel == 5):
            self.length()
        elif (sel == 6):
            self.isempty()
        elif (sel == 7):
            self.front()
        elif (sel == 8):
            self.back()
        else:
            print('error')

N = int(sys.stdin.readline())

deque1 = Deque()
for _ in range(N):
    temp = sys.stdin.readline().strip()

    if (len(temp.split()) >= 2):
        sel, val = map(str, temp.split())
        deque1.callDeque(int(sel), val)
    else:
        deque1.callDeque(int(temp))