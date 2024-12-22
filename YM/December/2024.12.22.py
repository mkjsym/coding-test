#프로그래머스 정수 제곱근 판별
def solution(n):
    answer = 0
    
    geun = n ** (1/2)
    if (int(geun) != geun):
        answer = -1
    else:
        answer = (int(geun) + 1) ** 2
    
    return answer

#프로그래머스 하샤드 수
def solution(x):
    answer = True
    
    temp = x
    sum = 0
    while(x > 0):
        sum += (x % 10)
        x = x // 10
    
    if (temp % sum == 0):
        answer = True
    else:
        answer = False
    
    return answer

#프로그래머스 나누어 떨어지는 숫자 배열
def solution(arr, divisor):
    answer = []
    
    for i in arr:
        if (i % divisor == 0):
            answer.append(i)
            
    if (len(answer) > 0):
        answer.sort()
    else:
        answer = [-1]
    
    return answer

#프로그래머스 콜라츠 추측
def solution(num):
    answer = 0
    
    cnt = 0
    while (num != 1):
        if (num % 2 == 0):
            num = num // 2
        elif (num % 2 == 1):
            num *= 3
            num += 1
            
        cnt += 1
        if (cnt >= 500):
            cnt = -1
            break
            
    answer = cnt
    return answer

#프로그래머스 음양 더하기
def solution(absolutes, signs):
    answer = 123456789
    
    sum = 0
    for i in range(len(absolutes)):
        if (signs[i] == True):
            sum += absolutes[i]
        else:
            sum -= absolutes[i]
    
    answer = sum
    
    return answer

#프로그래머스 없는 숫자 더하기
def solution(numbers):
    answer = 0
    
    for i in range(1, 10):
        if (i not in numbers):
            answer += i
    
    return answer

#프로그래머스 제일 작은 수 제거하기
def solution(arr):
    answer = []
    
    mini = min(arr)
    for i in arr:
        if (i != mini):
            answer.append(i)
            
    if (len(answer) == 0):
        answer.append(-1)
    
    return answer