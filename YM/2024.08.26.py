#백준 1436 영화감독 슘
# def jongmal(N):
#     before = -1
#     cnt = 0
#     while (N > 0):
#         temp = N % 10
#         if (temp == 6):
#             if (cnt >= 1):
#                 if (before == 6):
#                     cnt += 1
#                 else:
#                     cnt = 1
#             else:
#                 cnt += 1

#         if (cnt == 3):
#             return True

#         N = N // 10
#         before = temp

#     return False

# N = int(input())

# i = 0
# cnt = 0
# while (cnt < N):
#     if (jongmal(i)):
#         cnt += 1

#     if (cnt == N):
#         break

#     i += 1

# print(i)


#백준 10989 수 정렬하기 3
N = int(input())

nums = []
for i in range(N):
    nums.append(int(input()))

nums.sort()
for i in nums:
    print(i)