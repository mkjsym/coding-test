#백준 1260 DFS와 BFS###################################################################
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