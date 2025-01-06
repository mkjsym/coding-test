#백준 2110 공유기 설치#######################################################
#이분탐색... 도저히 모르겠다 진짜 제대로 공부할 필요성을 느낌
import sys

N, C = map(int, sys.stdin.readline().split())

homes = []
for _ in range(N):
    homes.append(int(sys.stdin.readline()))
homes.sort()

s = 1
e = homes[-1] - homes[0]

while (s <= e):
    mid = (s + e) // 2
    cnt = 1
    cur = homes[0]

    for i in range(1, N):
        if (homes[i] - cur >= mid):
            cnt += 1
            cur = homes[i]

    if (cnt >= C):
        s = mid + 1
    else:
        e = mid - 1

print(e)