#백준 1934 최소공배수
# import sys

# def choiso(a, b):
#     if (a > b):
#         i = 1
#         j = 1
#         while (i <= b):
#             if (a * i == b * j):
#                 return a * i
#             if (a * i < b * j):
#                 i += 1
#             else:
#                 j += 1
#     else:
#         i = 1
#         j = 1
#         while (i <= a):
#             if (b * i == a * j):
#                 return b * i
#             if (b * i < a * j):
#                 i += 1
#             else:
#                 j += 1
    
# T = int(sys.stdin.readline().strip())

# results = []
# for i in range(T):
#     a, b = map(int, sys.stdin.readline().strip().split())

#     results.append(choiso(a, b))

# for i in results:
#     print(i)


#백준 28278 스택 2
import sys

class Stack:
    def __init__(self):
        self.data = []
        self.h_ptr = -1

    def push(self, a):
        self.data.append(a)
        self.h_ptr += 1

    def pop(self):
        if (self.h_ptr < 0):
            print(-1)
        else:
            temp = self.data.pop()
            self.h_ptr -= 1
            print(temp)

    def length(self):
        print(self.h_ptr + 1)
    
    def isEmpty(self):
        if (self.h_ptr < 0):
            print(1)
        else:
            print(0)

    def top(self):
        if (self.h_ptr < 0):
            print(-1)
        else:
            print(self.data[self.h_ptr])

    def callStack(self, sel, val = 0):
        if sel == 1:
            self.push(val)
        elif sel == 2:
            self.pop()
        elif sel == 3:
            self.length()
        elif sel == 4:
            self.isEmpty()
        elif sel == 5:
            self.top()
        else:
            print('error')

N = int(sys.stdin.readline().strip())
stack1 = Stack()

for _ in range(N):
    val = sys.stdin.readline().strip()

    if (len(val) == 1):
        stack1.callStack(int(val[0]))
    else:
        stack1.callStack(int(val[0]), int(val[2]))