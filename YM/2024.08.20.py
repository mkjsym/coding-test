#백준 2903 중앙 이동 알고리즘
# N = int(input())

# points = 2
# for i in range(N):
#     points = points + (points - 1)

# print(points * points)


#백준 11005 진법 변환 2
# def returnDigit(A):
#     A = int(A)
#     if (A >= 0 and A <= 9):
#         return chr(ord('0')+A)
#     elif (A >= 10 and A <= 35):
#         return chr(A+55)

# N, B = map(int, input().split())

# digits = []
# i = 1
# while(N > 0):
#     iter = N % (B ** i)
#     digits.append(returnDigit(iter / (B ** (i - 1))))
#     N = N - (iter)
#     i += 1

# digits = digits[::-1]
# for i in range(len(digits)):
#     print(digits[i], end="")


#백준 2292 벌집
