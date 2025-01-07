#프로그래머스 이상한 문자 만들기
def solution(s):
    answer = ''
    
    cnt = 0
    for i in s:
        if (i == ' '):
            cnt = 0
            answer += ' '
        else:
            if (cnt % 2 == 0):
                answer += i.upper()
                cnt += 1
            else:
                answer += i.lower()
                cnt += 1
    
    return answer

#프로그래머스 문자열을 정수로 바꾸기
def solution(s):
    answer = 0
    
    answer = int(s)
    
    return answer