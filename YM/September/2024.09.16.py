#백준 1934 최소공배수#################################################
# import sys

#유클리드 호제법에 대하여... 자세히 공부해야겠다.
# def returnLCM(a, b):
#     while (b != 0):
#         r = a % b
#         a = b
#         b = r
    
#     return a

# T = int(sys.stdin.readline())

# results = []
# for _ in range(T):
#     a, b = map(int, sys.stdin.readline().strip().split())

#     results.append((a * b) // returnLCM(a, b))

# for i in results:
#     print(i)


#백준 13241 최소공배수
import sys

A, B = map(int, sys.stdin.readline().split())

temp = A * B
while (B != 0):
        r = A % B
        A = B
        B = r
    
result = temp // A

print(result)