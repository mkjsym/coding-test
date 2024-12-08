#백준 1302 베스트셀러
import sys
input = sys.stdin.readline

N = int(input())

bookNames = []
bookNamesUnique = set()
for _ in range(N):
    temp = input().strip()
    bookNamesUnique.add(temp)
    bookNames.append(temp)

bookNamesUnique = list(bookNamesUnique)
bookNamesUnique.sort()
top = bookNamesUnique[0]
maxCount = bookNames.count(bookNamesUnique[0])

for i in range(1, len(bookNamesUnique)):
    if (maxCount < bookNames.count(bookNamesUnique[i])):
        top = bookNamesUnique[i]
        maxCount = bookNames.count(bookNamesUnique[i])

print(top)