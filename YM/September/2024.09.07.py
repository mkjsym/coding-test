#백준 1764 듣보잡
import sys

N, M = map(int, sys.stdin.readline().strip().split())

d = set()
for _ in range(N):
    d.add(sys.stdin.readline().strip())

cnt = 0
db = set()
for _ in range(M):
    temp = sys.stdin.readline().strip()
    if (temp in d):
        cnt += 1
        db.add(temp)

db = sorted(db)
print(cnt)
for i in db:
    print(i)