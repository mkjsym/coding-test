#백준 4949 균형잡힌 세상
import sys
from collections import deque

class Stack:
    def __init__(self):
        self.dq = deque([])
        self.len = 0

    def push(self, a):
        self.dq.append(a)
        self.len += 1

    def pop(self):
        if (self.len > 0):
            self.len -= 1
            return self.dq.pop()
        else:
            return -1
        
    def length(self):
        return self.len

while (True):
    munjang = sys.stdin.readline().rstrip()

    if (munjang == '.'):
        break

    stack1 = Stack()
    for i in munjang:
        if (i == '('):
            stack1.push('(')
        elif (i == ')'):
            if (stack1.pop() != '('):
                print('no')
                break
        elif (i == '['):
            stack1.push('[')
        elif (i == ']'):
            if (stack1.pop() != '['):
                print('no')
                break
        elif (i == '.'):
            if (stack1.length() == 0):
                print('yes')
            else:
                print('no')