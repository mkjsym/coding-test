#행렬 덧셈
# N, M = map(int, input().split())

# A = []
# for i in range(N):
#     A.append(list(map(int, input().split())))

# B = []
# for i in range(N):
#     B.append(list(map(int, input().split())))

# sum = []
# for i in range(N):
#     row = []
#     for j in range(M):
#         row.append(A[i][j] + B[i][j])
#     sum.append(row)

# for i in range(N):
#     for j in range(M):
#         print(sum[i][j], end=" ")
#     print()


#세로읽기
matrix = []

for i in range(5):
    matrix.append(input())

print(matrix[0][0])