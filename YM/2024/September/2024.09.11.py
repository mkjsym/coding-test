#백준 9012 괄호
import sys

def isVPS(string):
    stack = []
    h_ptr = -1
    for j in temp:
        if (j == '('):
            stack.append('(')
            h_ptr += 1
        elif (j == ')'):
            if (h_ptr == -1):
                return False
            stack.pop()
            h_ptr -= 1
        
    if (h_ptr != -1):
        return False
    
    return True

T = int(sys.stdin.readline().strip())

for _ in range(T):
    temp = sys.stdin.readline().strip()

    result = isVPS(temp)

    if (result):
        print('YES')
    else:
        print('NO')