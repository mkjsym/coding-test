#백준 1009 분산처리########################################################
import sys 
input = sys.stdin.readline

t=int(input())
for _ in range(t):
    a, b=map(int, input().split())
    base = a % 10

    if base == 0:
        print(10)
    elif base == 1 or base == 5 or base == 6:
        print(base)
    elif base == 4 or base == 9:
        if b % 2 == 0:
            print((base ** 2) % 10)
        else:
            print(base)
    else:
        if b % 4 == 0:
            print(base ** 4 % 10)
        else:
            print(base ** (b % 4) % 10)

#이렇게 짜니까 시간 초과....
# import sys
# input = sys.stdin.readline

# T = int(input())

# results = []
# for _ in range(T):
#     a, b = map(int, input().split())

#     results.append((a ** b) % 10)

# for i in results:
#     print(i)