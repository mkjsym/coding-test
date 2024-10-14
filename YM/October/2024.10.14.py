#백준 2805 나무 자르기######################################################################
#쉽지 않은 이분탐색..
import sys

N, M = map(int, sys.stdin.readline().split())
trees = list(map(int, sys.stdin.readline().split()))
trees.sort()

s = 1
e = max(trees)

while (s <= e):
    mid = (s + e) // 2
    
    cnt = 0
    for i in trees:
        if (i > mid):
            cnt += i - mid

    if (cnt >= M):
        s = mid + 1
    else:
        e = mid - 1

print(e)