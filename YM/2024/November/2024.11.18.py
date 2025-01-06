#백준 11004 K번째 수
import sys
input = sys.stdin.readline

N, K = map(int, input().split())

nums = list(map(int, input().split()))
nums.sort()

print(nums[K - 1])