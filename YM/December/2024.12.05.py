#백준 1009 분산처리
import sys
input = sys.stdin.readline

T = int(input())

results = []
for _ in range(T):
    a, b = map(int, input().split())

    results.append((a ** b) % 10)

for i in results:
    print(i)