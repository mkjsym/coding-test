#백준 2108 통계학#######################################################
#round() 함수의 사용법과 최빈값 구하는 알고리즘을 다시 공부하자
import sys

N = int(sys.stdin.readline())

nums = []
total = 0
counts = dict()
for _ in range(N):
    temp = int(sys.stdin.readline())
    total += temp
    nums.append(temp)
    if (temp not in counts):
        counts[temp] = 1
    else:
        counts[temp] += 1

nums.sort()

one = sum(nums) / len(nums)
two = nums[len(nums) // 2]

freq = max(counts.values())
num = []
for k, v in counts.items():
    if (v == freq):
        num.append(k)
if (len(num) == 1):
    three = num[0]
else:
    three = sorted(num)[1]

four = nums[-1] - nums[0]

print(round(one))
print(two)
print(three)
print(four)


#백준 20920 영단어 암기는 괴로워
# import sys

# N, M = map(int, sys.stdin.readline().split())

# words = []
# for _ in range(N):
#     temp = sys.stdin.readline().strip()

#     if (len(temp) >= M):
#         words.append(temp)

# words.sort()
# words.sort(key = len)
# words.sort(key = lambda x : words.count(x))

# print(words)

# results = set()
# for i in words:
#     if (i not in results):
#         results.add(i)
#         print(i)