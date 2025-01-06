### 백준 14501 퇴사

1. 문제 설명:

    상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.

    오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.

    백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.

    각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.

    상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.

2. 풀이 방법:

    동적 계획법을 사용하여 해결할 수 있는 문제. 어렵다.

3. 코드:
```python
#동적 계획법을 사용하여서 풀어야 하는 문제.
import sys
input = sys.stdin.readline

N = int(input())

table = []
for _ in range(N):
    table.append(list(map(int, input().split())))

dp = [0 for i in range(N + 1)]

for i in range(N):
    for j in range(i + table[i][0], N + 1):
        if (dp[j] < dp[i] + table[i][1]):
            dp[j] = dp[i] + table[i][1]

print(dp[-1])
```
***
### 백준 2606 바이러스

1. 문제 설명:

    신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

    예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.

    어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.

2. 풀이 방법:

    DFS를 활용하여 해결할 수 있는 문제. 입력받은 정점과 간선들을 이용하여 그래프 배열을 만든다. 재귀함수 형태의 DFS 함수를 이용해 깊이 우선 탐색을 수행한다. 깊이 우선 탐색 중 정점들을 지날 때마다 count 변수의 값을 1씩 증가시키고 재귀함수의 호출이 끝나면 count 변수의 값을 출력한다.

3. 코드:
```python
import sys
input = sys.stdin.readline

N = int(input())
V = int(input())

graph = [[] for _ in range(N + 1)]

for i in range(V):
    a, b = map(int, input().split())

    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (N + 1)
count = -1

def DFS(v):
    visited[v] = True
    global count
    count += 1
    for i in graph[v]:
        if not visited[i]:
            DFS(i)

DFS(1)
print(count)
```
***
### 백준 1260 DFS와 BFS

1. 문제 설명:

    그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

2. 풀이 방법:

    깊이 우선 탐색은 재귀를 사용하여 구현할 수 있다. 넓이 우선 탐색은 큐를 사용하여 구현할 수 있다.

3. 코드:
```python
#dfs와 bfs의 기초를 공부할 수 있는 문제
import sys
input = sys.stdin.readline

N, M, V = map(int, input().split())

graph = [[0] * (N + 1) for _ in range(N + 1)]
for i in range(M):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

visited1 = [0] * (N + 1)
visited2 = visited1.copy()

def dfs(v):
    visited1[v] = 1
    print(v, end = ' ')
    for i in range(1, N + 1):
        if (graph[v][i] == 1 and visited1[i] == 0):
            dfs(i)

def bfs(v):
    queue = [v]
    visited2[v] = 1
    while (queue):
        v = queue.pop(0)
        print(v, end = ' ')
        for i in range(1, N + 1):
            if (visited2[i] == 0 and graph[v][i] == 1):
                queue.append(i)
                visited2[i] = 1

dfs(V)
print()
bfs(V)
```
***
### 백준 1009 분산처리

1. 문제 설명:

    재용이는 최신 컴퓨터 10대를 가지고 있다. 어느 날 재용이는 많은 데이터를 처리해야 될 일이 생겨서 각 컴퓨터에 1번부터 10번까지의 번호를 부여하고, 10대의 컴퓨터가 다음과 같은 방법으로 데이터들을 처리하기로 하였다.

    1번 데이터는 1번 컴퓨터, 2번 데이터는 2번 컴퓨터, 3번 데이터는 3번 컴퓨터, ... ,

    10번 데이터는 10번 컴퓨터, 11번 데이터는 1번 컴퓨터, 12번 데이터는 2번 컴퓨터, ...

    총 데이터의 개수는 항상 ab개의 형태로 주어진다. 재용이는 문득 마지막 데이터가 처리될 컴퓨터의 번호가 궁금해졌다. 이를 수행해주는 프로그램을 작성하라.

2. 풀이 방법:

    단순히 컴퓨터의 대수인 10으로 데이터의 개수에 대하여 나머지 연산을 수행한 결과를 출력하는 것은 제곱 연산자의 연산 시간때문에 시간 초과가 떴다. 0부터 9까지의 모든 경우에 대하여 if else 문을 활용하여 특정 값을 출력하도록 코드를 짜야한다.

3. 코드:
```python
import sys 
input = sys.stdin.readline

t=int(input())
for _ in range(t):
    a, b=map(int, input().split())
    base = a % 10

    if base == 0:
        print(10)
    elif base == 1 or base == 5 or base == 6:
        print(base)
    elif base == 4 or base == 9:
        if b % 2 == 0:
            print((base ** 2) % 10)
        else:
            print(base)
    else:
        if b % 4 == 0:
            print(base ** 4 % 10)
        else:
            print(base ** (b % 4) % 10)

#이렇게 짜니까 시간 초과....
# import sys
# input = sys.stdin.readline

# T = int(input())

# results = []
# for _ in range(T):
#     a, b = map(int, input().split())

#     results.append((a ** b) % 10)

# for i in results:
#     print(i)
```
***