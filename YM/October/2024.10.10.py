#백준 24060 알고리즘 수업 - 병합 정렬 1
# import sys

# def merge_sort(arr, k):
#     if (len(arr) < 2):
#         return arr
    
#     mid = len(arr) // 2
#     low = merge_sort(arr[:mid], k)
#     high = merge_sort(arr[mid:], k)

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
#         if (cnt == k):
#             return merged[-1]
    
#     if (len(low[l:]) > 0):
#         for i in low[l:]:
#             merged.append(i)
#             cnt += 1
#             if (cnt == k):
#                 return merged[-1]
#     if (len(high[h:]) > 0):
#         for i in high[h:]:
#             merged.append(i)
#             cnt += 1
#             if (cnt == k):
#                 return merged[-1]

#     return merged, -1

# A, K = map(int, sys.stdin.readline().split())

# array = list(map(int, sys.stdin.readline().split()))

# print(merge_sort(array, K))


#백준 4779 칸토어 집합
import sys

def cantore(string):
    if (len(string) <= 1):
        return string
    else:
        low = string[:len(string) // 3]
        mid = string[len(string) // 3:(len(string) // 3) * 2]
        high = string[(len(string) // 3) * 2:]

        mid = ' ' * (len(mid))  

        return cantore(low) + mid + cantore(high)

results = []
while True:
    try:
        N = int(sys.stdin.readline())
        init = '-' * (3 ** N)
        results.append(cantore(init))
    except:
        break

for i in results:
    print(i)