#백준 10816 숫자 카드 2################################################
# import sys

# N = int(sys.stdin.readline().strip())
# have = list(map(int, sys.stdin.readline().strip().split()))

# M = int(sys.stdin.readline().strip())
# cards = list(map(int, sys.stdin.readline().strip().split()))

# counts = {}
# for i in have:
#     if (i in counts):
#         counts[i] += 1
#     else:
#         counts[i] = 1

# for i in cards:
#     #딕셔너리 함수 .get()의 사용법을 익혀두자.. 찾고자 하는 key가 존재하지 않을 경우 None을 반환
#     result = counts.get(i)
#     if (result == None):
#         print(0, end = ' ')
#     else:
#         print(result, end = ' ')


#