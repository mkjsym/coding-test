#백준 4673 셀프 넘버
def self_num(n):
    nums = list(str(n))

    sum = 0
    for i in nums:
        sum += int(i)

    return sum + n

result = set()
for i in range(10000):
    result.add(self_num(i))
for i in range(1, 10001):
    if i not in result:
        print(i)