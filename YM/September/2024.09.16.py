#백준 1934 최소공배수
import sys

def returnLCM(a, b):
    while (b != 0):
        r = a % b
        a = b
        b = r
    
    return a

T = int(sys.stdin.readline())

results = []
for _ in range(T):
    a, b = map(int, sys.stdin.readline().strip().split())

    results.append((a * b) // returnLCM(a, b))

for i in results:
    print(i)