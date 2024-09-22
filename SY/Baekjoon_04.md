# 백준 2346. 풍선 터뜨리기

### 문제 설명:

<p>1번부터 N번까지 N개의 풍선이 원형으로 놓여 있고, 풍선 안에는 -N <= x <= N인 정수가 적혀있는 종이가 들어있다. 제일 처음에 1번 풍선을 터뜨리고, 풍선 안에 있는 종이에 적힌 값만큼 이동하여 다음 풍선을 터뜨린다. 양수일 경우 오른쪽, 음수일 경우 왼쪽으로 이동한다. 터진 풍선 번호를 차례로 출력하여라.</p>

### 풀이:

덱을 `LinkedList`로 생성하면 메모리초과. `ArrayDeque`로 생성. `ArrayDeque`가 `LinkedList`보다 메모리 효율적, 연산속도 빠름.<br>
덱에 [종이번호, 풍선순서] 배열을 넣고, 적힌 번호만큼 풍선을 맨 뒤 또는 맨 앞으로 옮기는 방식<br>


1. `ArrayDeque`로 덱 생성

2. [종이번호, 풍선순서] 배열을 덱에 넣음.

3. 맨 앞 풍선에 적힌 숫자를 변수에 저장해두고 `peekFirst()`,  풍선 제거 `pollFirst()`.

4. 숫자가 양수이면 적힌 숫자만큼 맨 앞 풍선을 맨 뒤로 옮기기

5. 숫자가 음수이면 적힌 숫자만큼 맨 뒤 풍선을 맨 앞으로 옮기기
   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {		
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. ArrayDeque로 덱 생성
		Deque <int[]> deque = new ArrayDeque<>();
		
		// 2. [종이 번호, 풍선 순서]를 덱에 넣음. 
		for(int i=1; i<=N; i++) {
			int [] balloon = new int[] {Integer.parseInt(st.nextToken()), i}; 
			deque.offer(balloon);
		}

		while(!deque.isEmpty()) {
			// 3. 맨 앞 풍선에 적힌 숫자 얻고 터뜨리기
			int balloon[] = deque.peekFirst();
			int num = balloon[0];
			sb.append(balloon[1]).append(" ");
			deque.pollFirst();
			
			if(deque.isEmpty()) break;
			
			// 4. 숫자가 양수이면 숫자만큼 맨 앞 풍선을 맨 뒤로 옮기기
			if(num > 0) {
				for(int i=0; i<num-1; i++) {
					deque.offerLast(deque.pollFirst());
				}
			}
			// 5. 음수이면 맨 뒤 풍선을 맨 앞으로 옮기기
			else {
				for(int i=num; i<0; i++) {
					deque.offerFirst(deque.pollLast());
				}
			}
		}
		System.out.println(sb);
	}
}
```

<br><br>

# 백준 24511. queuestack

### 문제 설명:

<p> queue 또는 stack으로 이루어진 자료구조가 1번부터 N번까지 나열되어있다. $x_{n-1}$을 n-1번 자료구조에 삽입한 뒤, n-1번 자료구조에서 원소를 pop하고, pop된 원소 $x_n$을 n번 자료구조에 삽입한다. 이 과정을 1~N번 자료구조까지 반복했을 때, 마지막에 pop된 원소를 출력하라.<br>
첫째줄에 자료구조의 개수 N, 둘째줄에 자료구조 타입(큐=0, 스택=1), 셋째줄에 자료구조에 들어있는 원소, 넷째줄에 삽입할 원소의 개수, 다섯째줄에 삽입할 원소들이 입력으로 주어진다.</p>

### 풀이:

-큐, 스택의 원소를 모두 덱에 넣었더니 시간초과 => stack은 삽입된 원소가 바로 pop되므로 의미없음. 큐의 원소만 덱에 넣기. <br>
-반복문으로 하나씩 덱에 추가-제거했더니 시간초과 => 맨 앞에 삽입할 원소 추가, 맨 뒤 값만 pop하는 방식으로 시간단축축<br>

1. 자료구조 타입(큐 or 스택)을 배열에 저장

2. 큐의 원소만 덱에 넣기

3. 삽입할 값을 맨 앞에 추가, 맨 뒤 원소만 pop
   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] queuestack = new int[N];
		Deque <Integer> deque = new ArrayDeque<>();
		
		// 1. 자료구조 타입(큐or스택)을 배열에 저장
		for(int i=0; i<N; i++) {
			queuestack[i] = Integer.parseInt(st.nextToken());
		}
		
		// 2. 큐의 원소를 덱에 넣음
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(queuestack[i] == 0)
				deque.offer(num);
		}
		
		// 3. 삽입할 값을 맨앞에 추가, 맨 뒤 원소만 pop
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int x = Integer.parseInt(st.nextToken());
			deque.offerFirst(x);
			sb.append(deque.pollLast()).append(" ");
		}
		System.out.println(sb);
	}
}
```

<br><br>

# 백준 4134. 다음 소수

### 문제 설명:

<p>정수 n보다 크거나 같은 소수 중 가장 작은 소수를 테스트 케이스별로 한 줄에 하나씩 출력하라. (0 <= n <= 4 * $10^9$)</p>

### 풀이:

n/2까지 나눠서 소수 검사하는 방식은 시간초과. 루트 n까지만 나눠서 시간단축.<br>

1. 0과 1은 소수가 아니므로 가장 작은 소수는 2.

2. 2부터 루트 n까지 돌면서 나누어 떨어지는지 확인. 나누어 떨어지는 수가 없으면 소수
   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			long n = Long.parseLong(br.readLine());
			if(n==0 || n==1) {
				sb.append(2).append("\n");
				continue;
			}
			while(true) {
				Boolean isPrime = true;		
				// 루트 n까지만 나눠서 소수 검사
				for(long j=2; j<=Math.sqrt(n); j++) {
					if(n%j==0) {
						isPrime = false;
						break;
					}
				}
				if(isPrime) break;
				n++;
			}
			sb.append(n).append("\n");
		}
		System.out.println(sb);
	}
}
```

<br><br>

# 백준 17103. 골드바흐 파티션

### 문제 설명:

<p> 짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다. 짝수 N의 골드바흐 파티션의 수를 출력하라. 두 소수의 순서만 다른 것은 같은 파티션이다.</p>

### 풀이:

기존의 루트n까지 나눠서 찾는 방법은 시간초과. 에라토스테네스의 체 이용.<br>
-에라토스테네스의 체: 소수들의 배수를 지우는 방식으로 소수를 찾는 방법<br>
모든 수에 대하여 소수를 판별한 뒤, 골드바흐 파티션의 개수를 셈.

1. 입력범위만큼의 수를 담을 Boolean 배열 생성

2. 초깃값은 모두 true로 설정. 0과 1은 소수가 아니므로 false

3. 배열에 있는 숫자 i가 소수(true)이면 i의 배수를 모두 false로 만듦.

4. 3의 과정을 i= 루트 len까지만 반복.

5. N-i와 i가 모두 소수이면 골드바흐 파티션. 순서만 다른 것은 같은 파티션이므로 2/N까지만 검사.
   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int len = 1000000;
		
		// 1. 모든 수에 대하여 소수 판별(에라토스테네스의 체)
		Boolean isPrime [] = new Boolean[len+1] ;
		isPrime[0] = isPrime[1] = false;
		for(int i=2; i<isPrime.length; i++) {
			isPrime[i] = true;
		}
		
		for(int i=2; i<=Math.sqrt(len); i++) {
			if(isPrime[i]) {
				for(int j=i*i; j<=len; j+=i)
					isPrime[j] = false;
			}
		}
		
		// 2. 골드바흐 파티션 개수 세기
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			for(int i=2; i<=N/2; i++) {
				if(isPrime[i]&&isPrime[N-i])
					cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
```
