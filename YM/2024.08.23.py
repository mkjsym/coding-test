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
results = []
while (1):
    n = int(input())
    if (n == -1):
        break

    temp = []
    i = 1
    while (i < n):
        if ((n % i) == 0):
            temp.append(i)
        i += 1
    
    sum = 0
    for j in temp:
        sum += j

    if (n == sum):
        result = str(n) + ' = '
        for index, j in enumerate(temp):
            if (index + 1 == len(temp)):
                result += str(j)
            else:
                result += str(j) + ' + '
        results.append(result)
    else:
        results.append(str(n) + ' is NOT perfect.')

for i in results:
    print(i)