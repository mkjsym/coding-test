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
# S = input()

# cnt = 0
# beforeNull = False
# if (S[0] != " "):
#     cnt += 1
# else:
#     beforeNull == True

# for i in range(len(S)):
#     if (S[i] != " "):
#         if (beforeNull == True):
#             cnt += 1
#         beforeNull = False
#     else:
#         beforeNull = True

# print(cnt)


#상수
# a, b = input().split()

# a = a[::-1]
# b = b[::-1]

# if (int(a) > int(b)):
#     print(a)
# else:
#     print(b)


#다이얼
# S = input()

# sum = 0
# for i in range(len(S)):
#     if ((64 < ord(S[i])) and (ord(S[i]) <= 67)):
#         sum += 3
#     elif ((67 < ord(S[i])) and (ord(S[i]) <= 70)):
#         sum += 4
#     elif ((70 < ord(S[i])) and (ord(S[i]) <= 73)):
#         sum += 5
#     elif ((73 < ord(S[i])) and (ord(S[i]) <= 76)):
#         sum += 6
#     elif ((76 < ord(S[i])) and (ord(S[i]) <= 79)):
#         sum += 7
#     elif ((79 < ord(S[i])) and (ord(S[i]) <= 83)):
#         sum += 8
#     elif ((83 < ord(S[i])) and (ord(S[i]) <= 86)):
#         sum += 9
#     elif ((86 < ord(S[i])) and (ord(S[i]) <= 90)):
#         sum += 10

# print(sum)


#그대로 출력하기
# while True:
#     try:
#         S = input()
#         print(S)
#     except:
#         break


#별 찍기 - 7
# N = int(input())

# pivot = ((N * 2) - 1) // 2
# for i in range(N*2 - 1):
#     if (i <= pivot):
#         for j in range(N-1-i):
#             print(" ", end="")
#         for j in range(1+2*i):
#             print("*", end="")
#     else:
#         for j in range(i-pivot):
#             print(" ", end="")
#         for j in range(N*2-1-2*(i-pivot)):
#             print("*", end="")
#     print()


#팰린드롬인지 확인하기
# S = input()

# re = len(S) // 2

# result = 1
# for i in range(re):
#     if (S[i] != S[-(i+1)]):
#         result = 0
#         break

# print(result)


#단어 공부
# S = input().upper()
# S_list = list(set(S))
# cnts = []

# for i in S_list:
#     cnts.append(S.count(i))

# if cnts.count((max(cnts))) >= 2:
#     print("?")
# else:
#     print(S_list[cnts.index(max(cnts))])


#크로아티아 알파벳
# trans_list = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]

# S = input()

# for i in trans_list:
#     S = S.replace(i, "*")

# print(len(S))


#그룹 단어 체커
# N = int(input())

# cnt = 0
# for i in range(N):
#     S = input()

#     result = 1
#     char_list = []
#     before = ""
#     for j in S:
#         if (j not in char_list):
#             char_list.append(j)
#         else:
#             if (before != j):
#                 result = 0
#                 break
#         before = j

#     cnt += result

# print(cnt)


#너의 평점은
# total_time = 0
# total_grade = 0

# for i in range(20):
#     name, time, grade = input().split()

#     if (grade == 'A+'):
#         total_time += float(time)
#         total_grade += (4.5 * float(time))
#     elif (grade == "A0"):
#         total_time += float(time)
#         total_grade += (4.0 * float(time))
#     elif (grade == "B+"):
#         total_time += float(time)
#         total_grade += (3.5 * float(time))
#     elif (grade == "B0"):
#         total_time += float(time)
#         total_grade += (3.0 * float(time))
#     elif (grade == "C+"):
#         total_time += float(time)
#         total_grade += (2.5 * float(time))
#     elif (grade == "C0"):
#         total_time += float(time)
#         total_grade += (2.0 * float(time))
#     elif (grade == "D+"):
#         total_time += float(time)
#         total_grade += (1.5 * float(time))
#     elif (grade == "D0"):
#         total_time += float(time)
#         total_grade += (1.0 * float(time))
#     elif (grade == "F"):
#         total_time += float(time)

# mean = total_grade / (total_time)
# print(mean)