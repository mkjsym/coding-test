#백준 20920 영단어 암기는 괴로워############################################################
#sorted() 함수 + lambda 함수를 사용하면 다중 조건 정렬이 가능하다. lambda 및 정렬의 key에 대해서 공부하자.
import sys

N, M = map(int, sys.stdin.readline().split())

words = {}
for _ in range(N):
    temp = sys.stdin.readline().strip()
    if (len(temp) >= M):
        if (temp in words):
            words[temp] += 1
        else:
            words[temp] = 1

words = sorted(words.items(), key = lambda x : (-x[1], -len(x[0]), x[0]))

for i in words:
    print(i[0])