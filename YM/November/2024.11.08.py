#백준 10817 세 수
import sys
input = sys.stdin.readline

nums = list(map(int, input().split()))
nums.sort()

print(nums[1])
