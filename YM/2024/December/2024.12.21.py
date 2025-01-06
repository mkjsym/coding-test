#프로그래머스 문자열을 정수로 바꾸기
def solution(s):
    answer = 0
    
    answer = int(s)
    
    return answer

#프로그래머스 자연수 뒤집어 배열로 만들기
def solution(n):
    answer = []
    
    while (n > 0):
        answer.append(int(n%10))
        n = int(n / 10)
    
    return answer

#프로그래머스 정수 내림차순으로 배치하기
def solution(n):
    answer = 0
    
    temp = []
    while (n > 0):
        temp.append(int(n % 10))
        n = int(n / 10)
        
    temp.sort(reverse = True)
    
    temp_str = ''
    for i in temp:
        temp_str += str(i)
        
    answer = int(temp_str)
    
    return answer