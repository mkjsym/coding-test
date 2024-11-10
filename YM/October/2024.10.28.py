#백준 11399 ATM
import sys
input = sys.stdin.readline

N = int(input())

times = list(map(int, input().split()))

times.sort()
result = times[0]
total = 0

for i in times[1:]:
    total += result
    result = result + i

total += result
print(total)
