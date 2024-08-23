#백준 2501 약수 구하기
# K, N = map(int, input().split())

# i = 1
# cnt = 0
# while (i <= K):
#     nameoji = K % i
#     if (nameoji == 0):
#         cnt += 1
#         if (cnt == N):
#             print(i)
#             break

#     if (i >= K):
#         if (cnt < K):
#             print(0)

#     i += 1


#백준 9506 약수들의 합
# results = []
# while (1):
#     n = int(input())
#     if (n == -1):
#         break

#     temp = []
#     i = 1
#     while (i < n):
#         if ((n % i) == 0):
#             temp.append(i)
#         i += 1
    
#     sum = 0
#     for j in temp:
#         sum += j

#     if (n == sum):
#         result = str(n) + ' = '
#         for index, j in enumerate(temp):
#             if (index + 1 == len(temp)):
#                 result += str(j)
#             else:
#                 result += str(j) + ' + '
#         results.append(result)
#     else:
#         results.append(str(n) + ' is NOT perfect.')

# for i in results:
#     print(i)


#백준 1978 소수 찾기
# N = int(input())

# nums = list(map(int, input().split()))

# cnt = N
# for i in range(N):
#     start = nums[i]
#     if (start == 1):
#         cnt -= 1
#     elif (start > 1):
#         for j in range(1, start - 1):
#             if (start % (j + 1) == 0):
#                 cnt -= 1
#                 break

# print(cnt)


#백준 2581 소수
# def isPrime(a):
#     if (a < 2):
#         return False
#     i = 2
#     while (i * i <= a):
#         if (a % i == 0):
#             return False
#         i += 1
#     return True

# M = int(input())
# N = int(input())

# primes = []
# for i in range(M, N+1):
#     if (isPrime(i)):
#         primes.append(i)

# if (primes == []):
#     print(-1)
# else:
#     print(sum(primes))
#     print(min(primes))


#백준 11653 소인수분해
# def returnInsu(a):
#     i = 2
#     while (i <= a):
#         if (a % i == 0):
#             return i
#         i += 1
#     return False

# N = int(input())

# nums = []
# while (returnInsu(N)):
#     insu = returnInsu(N)
#     nums.append(insu)
#     N = N / insu

# for i in nums:
#     print(i)


#백준 27323 직사각형
# A = int(input())
# B = int(input())

# print(A * B)


#백준 1085 직사각형에서 탈출
# x, y, w, h = map(int, input().split())

# xp = w-x
# yp = h-y

# print(min(x, y, xp, yp))


#백준 3009 네 번째 점
# p1_x, p1_y = map(int, input().split())
# p2_x, p2_y = map(int, input().split())
# p3_x, p3_y = map(int, input().split())

# x = -1
# if (p1_x == p2_x):
#     x = p3_x
# else:
#     if (p2_x == p3_x):
#         x = p1_x
#     else:
#         x = p2_x

# y = -1
# if (p1_y == p2_y):
#     y = p3_y
# else:
#     if (p2_y == p3_y):
#         y = p1_y
#     else:
#         y = p2_y

# print(x, y)


#백준 15894 수학은 체육과목 입니다
# n = int(input())

# dulae = 4 * n

# print(dulae)


#백준 9063 대지
# N = int(input())

# x = []
# y = []
# for i in range(N):
#     a, b = map(int, input().split())

#     x.append(a)
#     y.append(b)

# print((max(x) - min(x)) * (max(y) - min(y)))


#백준 10101 삼각형 외우기
# a = int(input())
# b = int(input())
# c = int(input())

# if (a + b + c == 180):
#     if (a == 60 and b == 60 and c == 60):
#         print('Equilateral')
#     elif (a == b or a == c or b == c):
#         print('Isosceles')
#     else:
#         print('Scalene')
# else:
#     print('Error')


#백준 5073 삼각형과 세 변
# results = []
# while (1):
#     a, b, c = map(int, input().split())

#     if (a == 0 and b == 0 and c == 0):
#         break

#     if (max(a, b, c) < a + b + c - max(a, b, c)):
#         if (a == b == c):
#             results.append('Equilateral')
#         elif (a == b or a == c or b == c):
#             results.append('Isosceles')
#         else:
#             results.append('Scalene')
#     else:
#         results.append('Invalid')

# for i in results:
#     print(i)


#백준 14215 세 막대
# a, b, c = map(int, input().split())

# if (max(a, b, c) >= sum([a + b + c]) - max(a, b, c)):
#     print(sum([a + b + c]) - max(a, b, c) + sum([a + b + c]) - max(a, b, c) - 1)
# else:
#     print(a + b + c)


#백준 2798 블랙잭
