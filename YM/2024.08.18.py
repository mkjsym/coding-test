#진법 변환
# N, B = map(str, input().split())

# result = 0
# N = N[::-1]
# for i in range(len(N)):
#     asc = ord(N[i])
#     if (asc >= 48 and asc <= 57):
#         result += (asc - 48) * int(B) ** i
#     elif (asc >= 65 and asc <= 90):
#         result += (asc - 55) * int(B) ** i

# print(result)


#진법 변환 2
N, B = map(int, input().split())

result = ""
while(N > 0):
    