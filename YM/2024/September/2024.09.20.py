#백준 4134 다음 소수#########################################
#소수 판별 알고리즘을 다시 공부하자. 루트 N의 시간복잡도를 갖는 소수 판별 알고리즘
#테스트 케이스가 0 혹은 1일 때의 예외 처리를 빠트려서 처음에 오답이 됐었다. 정신 차려야지
# import sys

# n = int(sys.stdin.readline())

# def isPrime(num):
#     i = 2
#     while (i * i <= num):
#         if (num % i == 0):
#             return False

#         i += 1

#     return True

# results = []
# for _ in range(n):
#     test_case = int(sys.stdin.readline())
    
#     temp = test_case
#     while (True):
#         if (temp < 2):
#             results.append(2)
#             break
#         elif (isPrime(temp)):
#             results.append(temp)
#             break
#         temp += 1

# for i in results:
#     print(i)