#공 바꾸기
# N, M = map(int, input().split())

# basket = []
# for i in range(N):
#     basket.append(i+1)

# for i in range(M):
#     x, y = map(int, input().split())
#     temp = basket[x-1]
#     basket[x-1] = basket[y-1]
#     basket[y-1] = temp

# for i in range(N):
#     print(basket[i], end=" ")


#바구니 뒤집기
# N, M = map(int, input().split())

# basket = []
# for i in range(N):
#     basket.append(i+1)

# for i in range(M):
#     x, y = map(int, input().split())
#     for j in range((y-x+1) // 2):
#         temp = basket[x-1+j]
#         basket[x-1+j] = basket[y-1-j]
#         basket[y-1-j] = temp

# for i in range(N):
#     print(basket[i], end=" ")


#공 넣기
# N, M = map(int, input().split())

# basket = []
# for i in range(N):
#     basket.append(0)

# for i in range(M):
#     a, b, c = map(int, input().split())

#     for j in range(b-a+1):
#         basket[a-1+j] = c

# for i in range(N):
#     print(basket[i], end=" ")


#문자와 문자열
# S = input()
# i = int(input())

# print(S[i-1])


#단어 길이 재기
# s = input()

# print(len(s))


#문자열
# T = int(input())

# for i in range(T):
#     S = input()
#     print(S[0], S[-1], sep="")


#아스키 코드
# C = input()

# print(ord(C))


#숫자의 합
# N = int(input())
# S = input()

# sum = 0
# for i in range(N):
#     sum += int(S[i])

# print(sum)


#알파벳 찾기
# S = input() # a = 97

# results = []
# for i in range(26):
#     results.append(-1)

# for i in range(len(S)):
#     if (results[ord(S[i]) - 97] == -1):
#         results[ord(S[i]) - 97] = i

# for i in range(len(results)):
#     print(results[i], end=" ")


#문자열 반복
# T = int(input())

# tests = []
# for i in range(T):
#     S = input()
#     R, S = S.split()
#     result = ""
#     for j in range(len(S)):
#         for k in range(int(R)):
#             result += S[j]
#     tests.append(result)

# for i in range(T):
#     print(tests[i])


#단어의 개수
