#백준 2164 카드2
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
        if (self.len > -1):
            self.len -= 1
            return self.dq.popleft()
        else:
            return -1
    
    def size(self):
        return self.len + 1

N = int(sys.stdin.readline().strip())

queue1 = queue()
for i in range(N):
    queue1.push(i+1)

while(queue1.size() > 1):
    queue1.pop()
    temp = queue1.pop()
    queue1.push(temp)

print(queue1.pop())