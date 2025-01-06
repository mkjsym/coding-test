#백준 1541 잃어버린 괄호######################################################
import sys
input = sys.stdin.readline

string = input().strip()

nums = string.split('-')

sums = []

for i in nums:
    tmp = list(map(int, i.split('+')))

    sums.append(sum(tmp))

print(sums[0] - sum(sums[1:]))
