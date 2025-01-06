#백준 11729 하노이 탑 이동 순서###############################################
#근데 이거 N 값의 범위가 1~20인데 N이 20일 경우 시간 복잡도가 너무 커지는데 이게 맞나..?
import sys

def hanoi(N, start, mid, end):
    if (N == 1):
        print(start, end)
        return
    else:
        hanoi(N - 1, start, end, mid)
        print(start, end)
        hanoi(N - 1, mid, start, end)

N = int(sys.stdin.readline())

print(2 ** N -1)
hanoi(N, 1, 2, 3)