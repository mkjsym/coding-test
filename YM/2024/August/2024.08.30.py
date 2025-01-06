#백준 10989 수 정렬하기 3#####################################################
import sys
N = int(input())

nums = [0] * (10001)

for _ in range(N):
    nums[int(sys.stdin.readline())] += 1

for i in range(len(nums)):
    if (nums[i] != 0):
        for _ in range(nums[i]):
            print(i)

"""
1. input()보다는 sys.readline()을 쓰자.

2. 빈 리스트에 append()로 추가하는 것보단 입력 받을 개수 만큼 초기화된 리스트에 인덱스를 이용해서 접근해서 그 위치에 직접 입력받자.

3. 줄바꿈 할때엔 print()가 아니라 '\n', for문 마다 출력하지 말고 문자열 변수에 저장해놓고 한 번에 출력하자.
"""