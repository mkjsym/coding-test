#프로그래머스 두 수의 곱
def solution(num1, num2):
    answer = 0
    
    answer = num1 * num2
    
    return answer

#프로그래머스 나머지 구하기
def solution(num1, num2):
    answer = -1
    
    answer = num1 % num2
    
    return answer

#프로그래머스 두 수의 차
def solution(num1, num2):
    answer = 0
    
    answer = num1 - num2
    
    return answer

#프로그래머스 숫자 비교하기
def solution(num1, num2):
    answer = 0
    
    if (num1 == num2):
        answer = 1
    else:
        answer = -1
    
    return answer

#프로그래머스 자릿수 더하기 (코딩테스트 연습/연습문제/자릿수 더하기)
def solution(n):
    answer = 0
    
    while (n > 0):
        answer += int(n % 10)
        n /= 10

    return answer