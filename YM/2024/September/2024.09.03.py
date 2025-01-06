#백준 14425 문자열 집합
# import sys

# N, M = map(int, sys.stdin.readline().split())

# strs = set()
# for _ in range(N):
#     strs.add(sys.stdin.readline())

# cnt = 0
# for _ in range(M):
#     temp = sys.stdin.readline()
#     if (temp in strs):
#         cnt += 1

# print(cnt)


#백준 1620 나는야 포켓몬 마스터 이다솜###########################################################
import sys

N, M = map(int, sys.stdin.readline().split())

dic = {}
for i in range(N):
    temp = sys.stdin.readline().strip()
    dic[i + 1] = temp
    dic[temp] = i + 1

result = ""
for _ in range(M):
    temp = sys.stdin.readline().strip()

    if (temp.isdigit()):
        result += dic[int(temp)] + '\n'
    else:
        result += str(dic[temp]) + '\n'

print(result)