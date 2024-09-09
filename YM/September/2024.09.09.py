#백준 11478 서로 다른 부분 문자열의 개수
# import sys

# S = sys.stdin.readline().strip()

# bubun = set()
# for i in range(len(S)):
#     for j in range(len(S) - i):
#         bubun.add(S[j:j + i + 1])

# print(len(bubun))


#백준 1934 최소공배수
import sys

def choiso(a, b):
    if (a > b):
        i = 1
        j = 1
        while (i <= b):
            if (a * i == b * j):
                return a * i
            if (a * i < b * j):
                i += 1
            else:
                j += 1
    else:
        i = 1
        j = 1
        while (i <= a):
            if (b * i == a * j):
                return b * i
            if (b * i < a * j):
                i += 1
            else:
                j += 1
    
T = int(sys.stdin.readline().strip())

results = []
for i in range(T):
    a, b = map(int, sys.stdin.readline().strip().split())

    results.append(choiso(a, b))

for i in results:
    print(i)