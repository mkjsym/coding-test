#백준 18870 좌표 압축
import sys

N = int(sys.stdin.readline().strip())
nums = list(map(int, sys.stdin.readline().strip().split()))
nums_set = set(nums)
nums_set = sorted(nums_set)

dic = {}
for i in range(len(nums_set)):
    dic[nums_set[i]] = i

for i in nums:
    print(dic[i], end = " ")
print()