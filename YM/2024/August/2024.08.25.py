#백준 24313 알고리즘 수업 - 점근적 표기 1##################################
# a1, a0 = map(int, input().split())
# c = int(input())
# n0 = int(input())

# if (a1 * n0 + a0 <= c * n0 and a1 <= c):
#     print(1)
# else:
#     print(0)


#백준 2798 블랙잭######################################################
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


#백준 2231 분해합
# def bunhae(a):
#     for i in range(1, a+1):
#         sum = 0
#         temp_i = i
#         while(i > 0):
#             sum += i % 10
#             i = i // 10

#         if (sum + temp_i == a):
#             return temp_i
        
#     return 0

# N = int(input())

# print(bunhae(N))


#백준 19532 수학은 비대면 강의입니다
# def returnIJ(a, b, c, d, e, f):
#     for i in range(-999, 1000):
#         for j in range(-999, 1000):
#             if ((a * i + b * j == c) and (d * i + e * j == f)):
#                 return i, j

#     return 0, 0

# a, b, c, d, e, f = map(int, input().split())

# x, y = returnIJ(a, b, c, d, e, f)

# print(x, y)


#백준 2750 수 정렬하기##########################################
# def minNum(numList):
#     minNum = numList[0]
#     minIndex = 0
#     for i in range(1, len(numList)):
#         if (minNum > numList[i]):
#             minNum = numList[i]
#             minIndex = i

#     return minIndex

# N = int(input())

# nums = []
# for i in range(N):
#     nums.append(int(input()))

# for i in range(N):
#     idx = minNum(nums[i:])
#     temp = nums[i]
#     nums[i] = nums[i+idx]
#     nums[i+idx] = temp

# for i in nums:
#     print(i)


#백준 2587 대표값2
# nums = []
# for i in range(5):
#     nums.append(int(input()))

# print(sum(nums) // len(nums))
# nums.sort()
# print(nums[2])


#백준 25305 커트라인
# N, k = map(int, input().split())

# scores = list(map(int, input().split()))

# scores.sort(reverse = True)
# print(scores[k-1])


#