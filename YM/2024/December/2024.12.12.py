#프로그래머스 n의 배수
def solution(num, n):
    answer = 0
    
    if (num % n == 0):
        answer = 1
    
    return answer

#프로그래머스 더 크게 합치기
def solution(a, b):
    answer = 0
    
    ab = str(a) + str(b)
    ba = str(b) + str(a)
    
    if (int(ab) >= int(ba)):
        answer = int(ab)
    else:
        answer = int(ba)
    
    return answer