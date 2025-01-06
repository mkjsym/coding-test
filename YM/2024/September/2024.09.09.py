#백준 11478 서로 다른 부분 문자열의 개수
import sys

S = sys.stdin.readline().strip()

bubun = set()
for i in range(len(S)):
    for j in range(len(S) - i):
        bubun.add(S[j:j + i + 1])

print(len(bubun))