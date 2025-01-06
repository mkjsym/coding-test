#프로그래머스 x만큼 간격이 있는 n개의 숫자
def solution(x, n):
    answer = []
    
    for i in range(n):
        answer.append(x + x * i)
    
    return answer

#프로그래머스 나머지가 1이 되는 수 찾기
def solution(n):
    answer = 0
    
    for i in range(1, n):
        if (n % i == 1):
            answer = i
            break
    
    return answer