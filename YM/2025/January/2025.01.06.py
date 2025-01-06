#프로그래머스 직사각형 별찍기
a, b = map(int, input().strip().split(' '))

result = ""
for i in range(b):
    layer = ""
    for j in range(a):
        layer += '*'
    result += layer + '\n'

print(result)

#프로그래머스 같은 숫자는 싫어
def solution(arr):
    answer = []
    
    answer.append(arr[0])
    before = arr[0]
    for i in arr[1:]:
        if (i != before):
            answer.append(i)
        before = i
    
    return answer