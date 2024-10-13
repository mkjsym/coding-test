#백준 1920 수 찾기
#난 또 특별한 알고리즘을 써서 풀어야하는 줄 알았는데.. set()을 활용한 빠른 입력과 in 문법을 사용한 검사로 해결할 수 있었다..
import sys

N = int(sys.stdin.readline())
Aarr = set(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())
Marr = list(map(int, sys.stdin.readline().split()))

for i in Marr:
    print('1') if i in Aarr else print('0')

#아래는 시간초과가 뜬 코드..
# import sys

# def binSearch(arr, v):
#     mid = len(arr) // 2
    
#     if (len(arr) <= 1):
#         if (arr[mid] != v):
#             return 0
        
#     if (arr[mid] == v):
#         return 1
#     elif (arr[mid] > v):
#         return binSearch(arr[:mid], v)
#     elif (arr[mid] < v):
#         return binSearch(arr[mid:], v)

# N = int(sys.stdin.readline())

# Aarr = list(map(int, sys.stdin.readline().split()))
# Aarr.sort()

# M = int(sys.stdin.readline())

# Marr = list(map(int, sys.stdin.readline().split()))

# for i in Marr:
#     print(binSearch(Aarr, i))