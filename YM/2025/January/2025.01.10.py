#프로그래머스 예산
def solution(d, budget):
    answer = 0
    
    d.sort()
    total = 0
    for i in d:
        if (total + i <= budget):
            total += i
            answer += 1
        else:
            break
    
    return answer
