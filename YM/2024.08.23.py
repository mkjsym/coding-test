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


#