#백준 2720 세탁소 사장 동혁
T = int(input())

results = []
for i in range(T):
    Q = 0
    D = 0
    N = 0
    P = 0

    C = int(input())
    Q = C // 25
    C = C % 25

    D = C // 10
    C = C % 10

    N = C // 5
    C = C % 5

    P = C

    results.append([Q, D, N, P])

for i in range(T):
    print(results[i][0], results[i][1], results[i][2], results[i][3])