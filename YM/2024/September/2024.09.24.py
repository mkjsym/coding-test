#백준 17103 골드바흐 파티션########################################################
#왤케 어려워 이거
#에라토스테네스의 체인지 에라이모르겠다 체인지에 대해서 공부하자.. 특정 범위까지 모든 소수를 찾아내는 데에 유용한 알고리즘이라고 한다
import sys

primes = []
check = [1, 1] + [0] * 999999

for i in range(2, 1000001):
    if (check[i] == 0):
        primes.append(i)
        for j in range(2*i, 1000001, i):
            check[j] = 1

T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())

    count = 0
    for j in primes:
        if (j >= N):
            break
        if ((not check[N - j]) and (j <= N - j)):
            count += 1

    print(count)