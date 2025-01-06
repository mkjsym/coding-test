#백준 4948 베르트랑 공준#########################################################
import sys

def isPrime(num):
    if (num < 2):
        return False
    
    i = 2
    while (i * i <= num):
        if (num % i == 0):
            return False
        
        i += 1

    return True

sosu = [1] * (123456 * 2)

for i in range(len(sosu)):
    if (isPrime(i+1)):
        sosu[i] = 1
    else:
        sosu[i] = 0

results = []
while (True):
    n = int(sys.stdin.readline())

    if (n == 0):
        break

    results.append(sum(sosu[n:n * 2]))

for i in results:
    print(i)

#이렇게 하니까 시간 초과가 뜬다. 아무래도 n이 123,456까지인 범위를 이용해서 미리 소수 리스트를 만들어 놓는 방법으로 다시 풀어 보아야겠다.
# import sys

# def isPrime(num):
#     if (num < 2):
#         return False
    
#     i = 2
#     while (i * i <= num):
#         if (num % i == 0):
#             return False
        
#         i += 1

#     return True

# results = []
# while (True):
#     n = int(sys.stdin.readline())

#     if (n == 0):
#         break

#     cnt = 0
#     for i in range(n + 1, 2 * n + 1):
#         if (isPrime(i)):
#             cnt += 1

#     results.append(cnt)

# for i in results:
#     print(i)