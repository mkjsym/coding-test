# 백준 1654. 랜선자르기

### 문제 설명:

<p>길이가 제각각인 랜선 K개를 가지고 있다. K개의 랜선을 잘라서 모두 N개의 같은 길이의 랜선으로 만들려고 할 때, 만들 수 있는 최대 랜선의 길이를 구하여라. (1 <= K <= 10000, 1 <= N <= 1,000,000, K <= N, 랜선의 길이는 $2^{31} - 1$이하 자연수)</p>

### 풀이:

이분탐색의 기준을 랜선의 길이로 함. 우선 절반으로 나눠서 자를 길이를 구하고, 만들 수 있는 랜선의 개수를 구함. 만약 구한 랜선의 개수가 더 적으면 길이를 줄이고, 많으면 길이를 늘림.<br>

1. 자를 수 있는 최소길이 `min`=1로 초기화하고 최대길이 `max`는 가장 긴 랜선의 길이로 초기화

2. 절반으로 나눠 자를 길이 `mid`를 구함

3. `mid`길이로 만들 수 있는 랜선의 개수 구함

4. 구한 개수가 구하려는 개수보다 더 적으면 자를 길이 줄이기(최대길이 -1)

5. 구한 개수가 더 많으면 자를 길이 늘리기(최소길이 +1)
   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {		
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[K];
		long max = 0, min = 1;
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}

		while(min <= max) {
			// mid = 자를 길이
			long mid = (min + max) / 2;
			long cnt = 0;
			
			// mid 길이로 만들 수 있는 랜선 개수 count
			for(int i=0; i<arr.length; i++) {
				cnt += (arr[i]/mid);
			}
			
			// 랜선 개수가 구하려는 개수보다 작으면 길이 줄이기
			if(cnt < N) {
				max = mid-1;
			}
			// 랜선 개수가 구하려는 개수보다 많으면 길이 키우기
			else {
				min = mid + 1;
			}
		}
		System.out.println(max);
	}
}

```

<br><br>


# 백준 2110. 공유기 설치

### 문제 설명:

<p> $x_1, ..., x_N$의 좌표를 가지는 집 N개가 수직선 위에 있다. C개의 공유기를 N개의 집에 적당히 설치해서 가장 인접한 두 공유기 사이 거리를 최대로 하는 프로그램을 작성하시오. 한 집에는 공유기를 하나만 설치할 수 있다. (2 <= N <= 200,000, 2<= c <= N, 0 <= $x_i$ <=1,000,000,000)</p>

### 풀이:

<p>설치 간격을 기준으로 탐색. 집의 좌표 정렬 후, 최소 설치 간격을 구한다. 구한 간격만큼으로 설치할 수 있는 공유기 수가 적으면 간격을 줄이고, 많으면 간격을 늘린다. <br>어떤걸 기준으로 탐색해야할지 생각하기!</p>

1. 집의 좌표를 오름차순 정렬

2. `min`과 `max`를 각각 첫번째집과 마지막 집으로 초기화

3. 절반으로 나눠 최소 설치 간격 `mid`를 구함

4. 첫번째 집에 설치한다고 가정하고, `mid`만큼의 간격으로 설치할 수 있는 공유기 개수 세기

5. 설치된 수가 설치해야 하는 수 보다 적으면 간격 줄이기

6. 설치해야하는 수 보다 많으면 간격 늘리기

### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main12 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int home[] = new int[N];
		for(int i=0; i<N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);
		
		int min = 1;	
		int max = home[N-1];
		
		while(min <= max) {
			// mid = 최소 설치 간격
			int mid = (min+max) / 2;
			
			// 첫번째집에 설치
			int loc = home[0];	
			int cnt = 1;		
			
			// mid만큼의 간격으로 공유기설치
			for(int i=1; i<N; i++) {
				if(home[i] - loc >= mid) {	
					loc = home[i];
					cnt++;
				}
			}
			
			// 설치된 수가 설치해야하는 수보다 적으면 간격 줄이기
			if(cnt < C) {
				max = mid -1;
			}
			// 많으면 간격 늘리기
			else {
				min = mid +1;
			}
		}
		System.out.println(max);
	}
}

```

<br><br>


# 백준 11286. 절댓값 힙

### 문제 설명:

<p>절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.<br><br>
1. 배열에 정수 x(x!=0)을 넣는다.<br>
2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는 가장 작은 수를 출력하고 그 값을 배열에서 제거한다.<br><br>
연산의 개수 N이 주어지고, x가 주어진다. 만약 x가 0이 아니라면 배열에 x값을 넣는 연산이고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거한다. 만약 배열이 비어있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력. ($-2^{31} < x < 2^{31}$)</p>

### 풀이:

<p>우선순위 큐 `PriorityQueue`를 음수 큐, 양수 큐로 분리. 우선순위큐는 기본적으로 오름차순 정렬</p>

1. x!=0이면: 양수는 `posQue`에, 음수의 절댓값은 `negQue`에 넣음. 

2. x==0이면:
   1) 만약 모든 큐가 비어있으면 0 출력

   2) 양수 큐만 비어있으면 음수 큐 값 출력, 음수 큐만 비어있으면 양수 큐 값 출력

   3) 모두 비어있지 않으면 두 개의 큐 중 최대 우선순위 값이 작은 값을 출력.

   4) 두 큐의 최대 우선순위 값이 같다면 음수 큐의 값 출력

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
		PriorityQueue<Integer> posQue = new PriorityQueue<>();
		PriorityQueue<Integer> negQue = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			// 값 넣기
			if(num > 0) posQue.add(num);
			else if(num < 0) negQue.add(Math.abs(num));
			
			// 값 빼기
			else {
				if(posQue.isEmpty() && negQue.isEmpty()) {
					sb.append(0);
				}
				else if(posQue.isEmpty()) {
					sb.append(negQue.poll()*(-1));
				}
				else if(negQue.isEmpty()) {
					sb.append(posQue.poll());
				}
				// 음수큐, 양수큐 모두 비어있지 않을 경우
				else {	
					int posNum = posQue.peek();
					int negNum = negQue.peek();
					if(posNum < negNum) 
						sb.append(posQue.poll());
					else if(posNum > negNum) 
						sb.append(negQue.poll()*(-1));
					else
						sb.append(negQue.poll()*(-1));	// 양수절댓값==음수절댓값이면 음수값 출력
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}


```
