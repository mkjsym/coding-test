#백준 1417 국회의원 선거
import sys
input = sys.stdin.readline

N = int(input())
dasom = int(input())
votes = []
for i in range(N - 1):
    votes.append(int(input()))
votes.sort()

count = 0
if (N == 1):
    print(0)
else:
    while (votes[-1] >= dasom):
        dasom += 1
        votes[-1] -= 1
        count += 1
        votes.sort()
    print(count)