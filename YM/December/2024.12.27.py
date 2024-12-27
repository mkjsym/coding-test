#프로그래머스 문자열 내림차순으로 배치하기
def solution(s):
    answer = ''
    
    uppers = []
    lowers = []
    for i in s:
        if (i.isupper()):
            uppers.append(i)
        else:
            lowers.append(i)
    
    uppers.sort(reverse = True)
    lowers.sort(reverse = True)
    if (len(lowers) > 0):
        for i in lowers:
            answer += i
    if (len(uppers) > 0):
        for i in uppers:
            answer += i
    
    return answer

#프로그래머스 행렬의 덧셈
def solution(arr1, arr2):
    answer = []
    
    for i in range(len(arr1)):
        temp = []
        for j in range(len(arr1[0])):
            temp.append(arr1[i][j] + arr2[i][j])
        answer.append(temp)
    
    return answer
