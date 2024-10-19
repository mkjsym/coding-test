#백준 24060 알고리즘 수업 - 병합 정렬 1##########################
#정렬 알고리즘 자체는 어렵지 않게 구현할 수 있었으나, 문제에서 요구하는 답을 출력하도록 만드는 것이 어려웠음
import sys

def merge_sort(arr, s, e):
    if (s < e):
        mid = (s + e) // 2
        merge_sort(arr, s, mid)
        merge_sort(arr, mid + 1, e)
        merge(arr, s, mid, e)

def merge(arr, s, mid, e):
    global cnt, result
    i = s
    j = mid + 1
    temp = []

    while (i <= mid and j <= e):
        if (arr[i] <= arr[j]):
            temp.append(arr[i])
            i += 1
        else:
            temp.append(arr[j])
            j += 1

    while (i <= mid):
        temp.append(arr[i])
        i += 1
    while (j <= e):
        temp.append(arr[j])
        j += 1
    
    i = s
    t = 0
    while (i <= e):
        arr[i] = temp[t]
        cnt += 1
        if cnt == K:
            result = arr[i]
            break
        i += 1
        t += 1

N, K = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

cnt = 0
result = -1
merge_sort(arr, 0, len(arr) - 1)

print(result)