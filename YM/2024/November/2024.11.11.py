#백준 2309 일곱 난쟁이########################################################
import sys
input = sys.stdin.readline

nanjaengs = []

for _ in range(9):
    nanjaengs.append(int(input()))

nanjaengs.sort()
total = sum(nanjaengs)
result = []
for i in range(9):
    for j in range(i + 1, 9):
        if (total - nanjaengs[i] - nanjaengs[j]) == 100:
            result.append(nanjaengs[i])
            result.append(nanjaengs[j])
            break
    if (len(result) >= 2):
        break

for i in nanjaengs:
    if i not in result:
        print(i)