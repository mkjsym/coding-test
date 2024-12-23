#프로그래머스 핸드폰 번호 가리기
def solution(phone_number):
    answer = ''
    
    for i in range(len(phone_number)):
        if (len(phone_number) - i < 5):
            answer += phone_number[i]
        else:
            answer += '*'
    
    return answer

#프로그래머스 내적
def solution(a, b):
    answer = 0
    
    for i in range(len(a)):
        answer += a[i] * b[i]
    
    return answer