#백준 1654 랜선 자르기
import sys

K, N = map(int, sys.stdin.readline().split())
lans = []
for _ in range(K):
    lans.append(int(sys.stdin.readline()))

s = 1
e = max(lans)
while (s <= e):
    mid = (s + e) // 2
    cnt = 0
    for i in lans:
        cnt += i // mid

    if (cnt >= N):
        s = mid + 1
    else:
        e = mid - 1

print(e)