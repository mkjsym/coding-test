#백준 1712 손익분기점
import sys
input = sys.stdin.readline

A, B, C = map(int, input().split())

if (C - B != 0):
    son = A / (C - B)
else:
    son = -1

if (son < 0):
    print('-1')
else:
    print(int(son) + 1)