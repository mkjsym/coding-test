#백준 2485 가로수###############################################################
#유클리드 호제법과 math 라이브러리의 gcd 함수를 공부하자.
#바쁘다고 이 문제는 너무 대충 보고 넘어갔으니 반드시 제대로 복습할 것.
import sys
from math import gcd

N = int(sys.stdin.readline())

garosu = []
a = int(sys.stdin.readline())
for i in range(1, N):
    num = int(sys.stdin.readline())
    garosu.append(num - a)
    a = num

g = garosu[0]
for i in garosu[1:]:
    g = gcd(g, i)

result = 0
for i in garosu:
    result += i // g - 1

print(result)