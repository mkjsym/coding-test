#최댓값
matrix = []

for i in range(9):
    row = list(map(int, input().split()))
    matrix.append(row)

max = -1
max_r = -1
max_c = -1
for i in range(len(matrix)):
    for j in range(len(matrix[0])):
        if (matrix[i][j] > max):
            max = matrix[i][j]
            max_r = i + 1
            max_c = j + 1

print(max)
print(max_r, max_c)