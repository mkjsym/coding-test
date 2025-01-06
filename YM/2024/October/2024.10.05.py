#백준 26069 붙임성 좋은 총총이
import sys

N = int(sys.stdin.readline())

choom = set()
choom.add('ChongChong')
for _ in range(N):
    temp1, temp2 = map(str, sys.stdin.readline().strip().split())

    if (temp1 in choom or temp2 in choom):
        choom.add(temp1)
        choom.add(temp2)

print(len(choom))