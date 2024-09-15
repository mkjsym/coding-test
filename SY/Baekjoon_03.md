# 백준 13241. 최소공배수

### 문제 설명:

<p>정수 A와 B의 최소공배수를 출력한다. <br>
(50%의 입력 중 A와 B는 1000($10^3$)보다 작다. 다른 50%의 입력은 1000보다 크고 100000000($10^8$)보다 작다.)</p>

### 풀이:

*******int 범위: -2,147,483,648 ~ 2,147,483,647<br><br>**
유클리드호제법: <br>
a % b = r 일 때, (a와 b의 최대공약수) = (b와 r의 최대공약수) <br>
`a % b = r`<br>
`b % r = r'`<br>
이 과정을 나머지가 0이 될 때까지 수행. 나머지가 0일 때의 나누는 수가 최대공약수<br>


1. 큰 수를 `big`, 작은 수를 `small`로 둠.

2. `rem = big % small`을 계산하고, `big`의 위치에 `small`을, `small`의 위치에 `rem`을 넣음.

3. 나머지가 0이 될 때까지 반복. 이때의 나누는 값 `small`이 최대공약수

4. 최소공배수는 (a * b) / (최대공약수)
   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		// 1. 작은 수를 small, 큰 수를 big으로 둠.
		long small = Math.min(A, B);
		long big = Math.max(A, B);
		
		// 2. 최대공약수(유클리드 호제법)
		while(small != 0) {
			long rem = big%small;
			big = small;
			small = rem;
		}
		long gcd = big;
		
		// 3. 최소공배수
		sb.append(A*B / gcd);
		
		System.out.println(sb);
	}
}
```

<br><br>

# 백준 2485. 가로수

### 문제 설명:

<p>심어진 가로수 N개의 위치가 주어질 때, 모든 가로수가 같은 간격이 되도록 새로 심어야 하는 가로수의 최소 개수를 출력한다.</p>

### 풀이:

최소개수로 심으려면 심어진 가로수 간격들의 최대공약수만큼의 간격을 가지도록 심어야 함.<br>
최대공약수를 구하는 함수 `GCD`를 정의해둠.<br>

1. 심어진 가로수 간 간격을 배열에 저장

2. 모든 간격의 최대공약수 계산

3. 배열을 순회하면서 간격 별로 들어갈 가로수 수 계산

4. (간격 별 가로수 수) = (간격) / (최대공약수) - 1
   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10 {
	public static int GCD(int s, int b) {
		if(s>b) {
			int tmp = s;
			s = b;
			b = tmp;
		}
		while(s!=0) {
			int rem = b%s;
			b = s;
			s = rem;
		}
		return b;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] gap = new int[N-1];
		
		// 1. 가로수 간 간격 구하기
		int pre = Integer.parseInt(br.readLine());
		for(int i=0; i<N-1; i++) {
			int now = Integer.parseInt(br.readLine());
			gap[i] = now - pre;
			pre = now;
		}
		
		// 2. 모든 간격의 최대공약수
		int gcd = gap[0];
		for(int i=1; i<gap.length; i++) {
			gcd = GCD(gcd, gap[i]);
		}

		// 3. 간격 별로 들어갈 나무 수
		int sum = 0;
		for(int g : gap) {
			sum += (g / gcd) - 1;
		}
		System.out.println(sum);
	}
}
```

<br><br>

# 백준 4949. 균형잡힌 세상

### 문제 설명:

<p>영문 알파벳, 공백, 소괄호, 대괄호로 이루어지고, 온점으로 끝나는 문자열이 주어진다. 문자열이 균형을 이루고 있으면 "yes", 아니면 "no"를 출력한다. 입력 종료 조건은 온점 하나가 들어올 경우.</p>

균형을 이루는 조건: <br>
- 소괄호는 소괄호와`'()'`, 대괄호는 대괄호`'[]'`와 1:1로 짝을 이룬다.
- 모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.
- 짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.  
   ex) '( [ ) ]' 는 균형잡힌 문자열 아님.

### 풀이:

여는괄호만 Stack에 `push`하고, 닫는괄호를 만나면 해당괄호를 `pop`함. 마지막에 Stack에 값이 남아있지 않으면 균형잡힌 문자열<br>

1. 온점 하나가 입력으로 들어올 때까지 문자열 한 줄씩 읽기

2. 여는 괄호 `'('` or `'['`이면 Stack에 넣기

3. 닫는 소괄호 `')'`일 경우:  
   - Stack이 비어있거나, Stack의 top이 소괄호 `'('`가 아니면 균형잡힌 문자열 아님. -> Stack에 값 하나 넣고 반복문 종료.  
   - 그렇지 않다면 `pop`
  
4. 닫는 대괄호 `']'`일 경우: 3과 같은 방식

5. 마지막에 Stack에 값이 남아있지 않으면 균형잡힌 문자열.

6. Stack의 값을 모두 지우고 새로운 문자열 읽어옴. 
   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main12 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack <Character> stack = new Stack<>();
		String str;
		
		while(!(str = br.readLine()).equals(".")) {
			for(char ch : str.toCharArray()) {
				if(ch=='(' || ch=='[') 
					stack.push(ch);
				else if(ch == ')') {
					if(stack.isEmpty() || stack.peek()!='(') {
						stack.push(ch);
						break;
					}
					stack.pop();
				}
				else if(ch == ']') {
					if(stack.isEmpty() || stack.peek()!='[') {
						stack.push(ch);
						break;
					}
					stack.pop();
				}	
			}
			
			if(stack.isEmpty()) sb.append("yes");
			else sb.append("no");
			sb.append("\n");
			
			stack.clear();
		}
		System.out.println(sb);
	}
}
```

<br><br>

# 백준 12789. 도키도키 간식드리미

### 문제 설명:

<p>학생들이 순서가 섞인채로 대기열에 줄을 서있다. 번호표 순서대로만 간식 라인에 들어갈 수 있고, 라인과 대기열의 맨 앞사람 사이에는 1열의 공간이 있다. 현재 대기열에 있는 사람들만 이 공간에 들어올 수 있다고 할 때, 모두가 순서대로 간식을 받을 수 있다면 "Nice", 그렇지 않으면 "Sad"를 출력한다. </p>

### 풀이:

1열의 공간을 Stack으로 만든 뒤, 뒷 번호부터 차례대로 넣어 오름차순 정렬하고 작은 번호부터 Stack에서 내보냄. Stack에서 나가는 번호가 가장 최근에 나간 번호보다 작으면 순서대로 나가지 못한 것이므로 간식받기 실패.<br>

1. 1열 공간을 Stack으로 만듦.

2. (대기열의 맨 앞 번호) < (Stack의 top)일 경우 Stack에 `push`. => Stack이 top에서부터 오름차순 정렬됨

3. 대기열의 맨 앞 번호가 더 크면 Stack의 top보다 작아질 때까지 `pop`. => 작은번호부터 순서대로 Stack에서 나가게 됨.

4. Stack에서 `pop`되는 번호가 가장 최근에 나간 번호`lastNum`보다 작으면 간식받기 실패.

5. Stack이 빌 때까지 `pop`하면서 간식받기 성공 여부 판단
   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main13 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int lastNum = 0;
		Boolean isNice = true;
		
		// 1. 1열짜리 공간을 stack으로 
		Stack <Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// 2. (대기열의 번호) < (stack의 top)일 경우에만 스택에 push. => 스택 오름차순 정렬   
			if(stack.isEmpty() || stack.peek()>num) {
				stack.push(num);
			}
			
			// 3. 대기열의 번호가 더 크면 작아질때까지 pop. (pop되는 번호) < (가장 최근에 나간 번호) 이면 간식받기 실패 
			while(!stack.isEmpty() && stack.peek()<num) {
				if(stack.peek() < lastNum) {
					isNice = false;
					break;
				}
				lastNum = stack.peek();
				stack.pop();
			}
			
		}

		// 4. 스택이 빌 때까지 반복해서 pop하기
		while(!stack.isEmpty()) {
			if(stack.peek() < lastNum) {
				isNice = false;
				break;
			}
			lastNum = stack.peek();
			stack.pop();
		}
		
		if(isNice) System.out.println("Nice");
		else System.out.println("Sad");
	}
}
```
