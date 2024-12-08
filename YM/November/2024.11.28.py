#백준 5635 생일
import sys
input = sys.stdin.readline

N = int(input())

informs = []
for _ in range(N):
    n, d, m, y = input().rstrip().split()
    d, m, y = map(int, (d, m, y))
    informs.append((y, m, d, n))

informs.sort()

print(informs[-1][3])
print(informs[0][3])