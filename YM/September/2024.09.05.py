#백준 10814 나이순 정렬
import sys

N = int(sys.stdin.readline().strip())

ages = set()
dic = {}
for _ in range(N):
    age, name = map(str, sys.stdin.readline().strip().split())

    if (int(age) in ages):
        dic[int(age)] = dic[int(age)] + ' ' + name
    else:
        ages.add(int(age))
        dic[int(age)] = name

dic = dict(sorted(dic.items()))

for i, v in dic.items():
    temp = v.split()

    for j in temp:
        print(i, j)