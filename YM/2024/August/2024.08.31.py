#백준 1018 체스판 다시 칠하기
# row, col = map(int, input().split())

# board = []
# for _ in range(row):
#     layer = []
#     string = input()
#     for j in range(col):
#         if (string[j] == 'W'):
#             layer.append(1)
#         else:
#             layer.append(0)
#     board.append(layer)

# counts = []
# cnt_a = 0
# cnt_b = 0
# for i in range(row - 8 + 1):
#     for j in range(col - 8 + 1):
#         for r in range(i, i + 8):
#             for c in range(j, j + 8):
#                 if ((r + c) % 2 == 0): #대각선 단위로 구별
#                     if (board[r][c] != 0): #해당 칸이 W인지 B인지 구별
#                         cnt_a += 1
#                     else:
#                         cnt_b += 1
#                 else:
#                     if (board[r][c] != 1):
#                         cnt_a += 1
#                     else:
#                         cnt_b += 1
#         counts.append(min(cnt_a, cnt_b))
#         cnt_a = 0
#         cnt_b = 0

# print(min(counts))


