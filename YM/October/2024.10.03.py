#백준 1037 약수
import sys

T = int(sys.stdin.readline())
N = set(map(int, sys.stdin.readline().split()))

if (T < 2):
    N = list(N)
    print(N[0] * N[0])
else:
    print(min(N) * max(N))