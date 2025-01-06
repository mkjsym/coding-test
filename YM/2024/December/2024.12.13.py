#프로그래머스 정수 부분
def solution(flo):
    answer = 0
    
    answer = int(flo)
    
    return answer

#프로그래머스 rny_string
def solution(rny_string):
    answer = ''
    
    splits = rny_string.split('m')
    for i in splits:
        answer += i + 'rn'
    
    return answer[:-2]

#프로그래머스 두 수의 연산값 비교하기
def solution(a, b):
    answer = 0
    
    tmp = str(a) + str(b)
    if (int(tmp) >= 2 * a * b):
        answer = int(tmp)
    else:
        answer = 2 * a * b
    
    return answer