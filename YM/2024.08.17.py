#세로읽기
# matrix = []

# for i in range(5):
#     matrix.append(input())

# result = []
# for i in range(15):
#     for j in range(5):
#         if (i < len(matrix[j])):
#             result.append(matrix[j][i])

# for i in result:
#     print(i, end="")


#색종이
# board = []
# for i in range(100):
#     row = []
#     for j in range(100):
#         row.append(0)
#     board.append(row)

# N = int(input())

# for i in range(N):
#     x, y = map(int, input().split())

#     for j in range(10):
#         for k in range(10):
#             board[j+x][k+y] = 1

# sum = 0
# for i in range(100):
#     for j in range(100):
#         sum += board[i][j]

# print(sum)


#진법 변환
