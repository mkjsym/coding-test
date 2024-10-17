#백준 24060 알고리즘 수업 - 병합 정렬 1
# import sys

# def merge_sort(arr):
#     if (len(arr) < 2):
#         return arr
    
#     mid = len(arr) // 2
#     low = merge_sort(arr[:mid])
#     high = merge_sort(arr[mid:])

#     merged = []
#     l = h = 0
#     cnt = 0
#     while ((l < len(low)) and (h < len(high))):
#         if (low[l] < high[h]):
#             merged.append(low[l])
#             l += 1
#             cnt += 1
#         else:
#             merged.append(high[h])
#             h += 1
#             cnt += 1
    
#     if (len(low[l:]) > 0):
#         for i in low[l:]:
#             merged.append(i)
#             cnt += 1
#     if (len(high[h:]) > 0):
#         for i in high[h:]:
#             merged.append(i)
#             cnt += 1

#     return merged

# A, K = map(int, sys.stdin.readline().split())

# array = list(map(int, sys.stdin.readline().split()))

# print(merge_sort(array))

# import sys

# def merge_sort(arr, s, e):
#     if (s < e):
#         mid = (s + e) // 2
#         merge_sort(arr, s, mid)
#         merge_sort(arr, mid, e)
#         merge(arr, s, mid, e)

# def merge(arr, s, mid, e):
#     i = s
#     j = mid + 1
#     temp = []

#     while (i <= mid and j <= e):
#         if (arr[i] <= arr[j]):
#             temp.append(arr[i])
#             i += 1
#         else:
#             temp.append(arr[j])
#             j += 1

#     while (i <= mid):
#         temp.append(arr[i])
#         i += 1
#     while (j <= e):
#         temp.append(arr[j])
#         j += 1
#     arr = temp

# N, K = map(int, sys.stdin.readline().split())

# arr = list(map(int, sys.stdin.readline().split()))

# merge_sort(arr, 1, len(arr))

# print(arr)


#백준 2447 별 찍기 - 10
import sys

def drawStar(x):
    if (x == 1):
        return '*'
    
    result = []
    temp = drawStar(x // 3)

    for i in temp:
        result.append(i * 3)
    for i in temp:
        result.append(i + ' ' * (len(i)) + i)
    for i in temp:
        result.append(i * 3)
    return result

N = int(sys.stdin.readline())

print('\n'.join(drawStar(N)))