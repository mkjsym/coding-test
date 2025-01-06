#백준 25501 재귀의 귀재
import sys

def recur(s, l, r, cnt = 0):
    cnt += 1
    if (l >= r):
        return 1, cnt
    elif (s[l] != s[r]):
        return 0, cnt
    else:
        return recur(s, l + 1, r - 1, cnt)

def isPal(st):
    return recur(st, 0, len(st) - 1)

T = int(sys.stdin.readline())

results = []
for _ in range(T):
    temp = sys.stdin.readline().strip()
    result= isPal(temp)
    results.append(result)

for r, c in results:
    print(r, c)