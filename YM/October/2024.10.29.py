#백준 13305 주유소
import sys
input = sys.stdin.readline

N = int(input())
roads = list(map(int, input().split()))
juyoo = list(map(int, input().split()))

min_price = juyoo[0]
total = min_price * roads[0]

for i in range(1, N - 1):
    if (juyoo[i] < min_price):
        min_price = juyoo[i]

    total += min_price * roads[i]

print(total)
