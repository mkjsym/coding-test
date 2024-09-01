#백준 2839 설탕배달
# def returnXY(n):
#     x = 0
#     while (x * 3 <= n):
#         y = 0
#         while(y * 5 <= n):
#             if (x * 3 + y * 5 == n):
#                 return x + y

#             y += 1
#         x += 1

#     return -1

# N = int(input())

# print(returnXY(N))


#백준 1427 소트인사이드
# N = list(input())

# N.sort(reverse = True)

# result = ""
# for i in N:
#     result = result + i

# print(result)


#백준 11650 좌표 정렬하기###########################
# import sys

# N = int(sys.stdin.readline())

# cords = []
# for _ in range(N):
#     x, y = map(int, sys.stdin.readline().split())

#     cords.append([x, y])

# cords.sort()

# for i in cords:
#     print(i[0], i[1])

#아래같은 방법은 시간초과가 떴다.. 왜지?
# result = ""
# for i in cords:
#     result = result + i[0] + ' ' + i[1] + '\n'

# print(result)


#백준 11651 좌표 정렬하기 2
# import sys

# N = int(sys.stdin.readline())

# coords = []
# for _ in range(N):
#     x, y = map(int, sys.stdin.readline().split())
#     coords.append([x, y])

# coords.sort(key = lambda x: (x[1], x[0]))

# for i in coords:
#     print(i[0], i[1])


#