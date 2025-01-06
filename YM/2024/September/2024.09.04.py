#백준 1181 단어 정렬########################################
import sys

N = int(sys.stdin.readline().strip())

#중복된 문자열은 제거하라고 하였기 때문에 set() 자료형을 사용
chars = set()
for _ in range(N):
    chars.add(sys.stdin.readline().strip())

#sort()는 리스트 전용 정렬 함수이며, sorted()는 리스트, 셋, 딕셔너리 모두 정렬이 가능한 정렬함수이다
#정렬 문제의 경우 조건 A, B가 주어질 경우 B 조건, A 조건 순으로 정렬하여야 한다
chars = sorted(chars)
chars = sorted(chars, key = len)

for i in chars:
    print(i)