#백준 11656 접미사 배열
import sys
input = sys.stdin.readline

S = input().strip()

Ss = []
for i in range(len(S)):
    Ss.append(S[i:])

Ss.sort()
for i in Ss:
    print(i)