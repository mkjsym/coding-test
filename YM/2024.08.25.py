#백준 24313 알고리즘 수업 - 점근적 표기 1
# a1, a0 = map(int, input().split())
# c = int(input())
# n0 = int(input())

# if (a1 * n0 + a0 <= c * n0 and a1 <= c):
#     print(1)
# else:
#     print(0)


#백준 2798 블랙잭
# N, M = map(int, input().split())
# cards = list(map(int, input().split()))

# result = 0
# for i in range(N):
#     for j in range(i + 1, N):
#         for k in range(j + 1, N):
#             temp = cards[i] + cards[j] + cards[k]

#             if (temp <= M):
#                 result = max(temp, result)

# print(result)


#