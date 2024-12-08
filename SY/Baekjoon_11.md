# 백준 17298. 오큰수

### 문제 설명:

<p>크기가 N인 수열 $A=A_1, A_2, ..., A_N$이 있다. 각 원소 $A_i$에 대해 오큰수 NGE(i)를 구하려고 한다. $A_i$의 오큰수는 오른쪽에 있으면서 $A_i$보다 큰 수 중에 가장 왼쪽에 있는 수를 의미한다. 그런 수가 없는 경우 오큰수는 -1이다. 총 N개의 오큰수를 공백으로 구분해 출력하라.</p>

### 풀이:

배열을 순회하면서, 현재 원소가 스택의 top이 가리키는 값보다 크면 해당 인덱스를 현재 원소로 업데이트하고, 그렇지 않으면 스택에 인덱스를 추가하는 방식<br>

1. 수열을 저장할 배열 `arr`과, 수열의 인덱스를 저장할 스택 `stack` 생성

2. 현재 원소가 스택의 top이 가리키는 값보다 크면 해당 인덱스의 값을 현재 원소로 업데이트. 

3. 그렇지 않을 경우 스택에 인덱스 추가.

4. 마지막에 스택에 남은 원소의 인덱스 값을 -1로 초기화

   
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
		Stack<Integer> stack = new Stack<>();
		int [] arr = new int[N];
	
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			// 현재 원소가 스택의 top보다 크면 해당 인덱스 값을 현재 원소로. 
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		// 마지막에 스택에 남은 원소의 인덱스값을 -1로 초기화
		while(!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		for(int i=0; i<N; i++)
			sb.append(arr[i] + " ");
		System.out.println(sb);
	}
}

```

<br><br>


# 백준 9935. 문자열 폭발

### 문제 설명:

<p>문자열에 폭발 문자열을 심어 놓았다. 폭발 문자열이 폭발하면 그 문자는 문자열에서 사라지며, 남은 문자열은 합쳐지게 된다. 폭발은 다음과 같은 과정으로 진행된다.<br><br>
1. 문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다. 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.<br>
2. 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다.<br>
3. 폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.<br><br>

모든 폭발이 끝난 후 남은 문자열을 출력한다. 남은 문자열이 없는 경우 "FRULA"를 출력한다.
</p>

### 풀이:

<p>스택에 문자를 차례로 저장하면서, 스택의 끝부분이 폭발문자열과 같을 경우 pop하여 제거.</p>

1. 문자들을 저장할 스택 `stack` 생성

2. 문자를 하나씩 저장하면서, 스택의 크기가 폭발문자열의 길이보다 클 경우에만 스택의 끝부분과 폭발문자열 비교

3. 스택의 끝부분이 폭발문자열과 같을 경우, `stack.pop()`으로 해당 길이만큼 문자 제거
  
4. 스택이 비어있을 경우 "FRULA" 출력, 남아있을 경우 스택의 모든 원소 출력


### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack <Character> stack = new Stack<>();
		String str = br.readLine();
		String bomb = br.readLine();
		int len = bomb.length();
		
		for(int i=0; i<str.length(); i++) {
			stack.push(str.charAt(i));
			if(stack.size() >= len) {
				boolean isBomb = true;
				for(int j=0; j<len; j++) {
					if(stack.get(stack.size() - len + j) != bomb.charAt(j)) {
						isBomb = false;
						break;
					}
				}
				if(isBomb) {
					for(int j=0; j<len; j++) {
						stack.pop();
					}
				}
			}
		}
		
		for(char c: stack) {
			sb.append(c);
		}
		System.out.println(stack.isEmpty() ? "FRULA" : sb);

	}
}


```


<br><br>


# 백준 11066. 파일합치기

### 문제 설명:

<p>각 파일을 합쳐서 최종적으로 한 개의 파일을 만든다. 이 과정에서 두 개의 파일을 합쳐서 하나의 임시파일을 만들고, 이 임시파일이나 원래의 파일을 계속 두 개씩 합쳐서 소설의 여러 장들이 연속이 되도록 파일을 합쳐나가고, 최종적으로는 하나의 파일로 합친다. 두 개의 파일을 합칠 때 필요한 비용이 두 파일 크기의 합이라고 가정할 때, 최종적인 한 개의 파일을 완성하는데 필요한 비용의 최솟값을 구하여라.</p>

### 풀이:

<p>파일을 from~to 구간으로 나누고, 이 구간에서 가능한 모든 분할 지점으로 분할해 두 구간을 합치는 비용을 계산한다. 그리고 이 비용의 최솟값을 찾아 전체를 합치는 비용을 계산한다.</p>

1. 각 파일의 비용을 저장할 배열 `arr`, 비용의 누적합을 저장할 배열 `sum`, 비용의 최솟값을 저장할 dp배열 `dp` 생성

2. 구간길이를 1~K까지 증가시키며 구간나눔
   1) from ~ to구간으로 나누고, `dp[from][to]` 초깃값은 `MAX_VALUE`로 초기화(작은구간부터 큰구간으로 계산하므로)
   2) from ~ to 구간을 가능한 모든 mid지점에서 나눔. ([from ~ mid], [mid+1 ~ to] 구간으로 나눔)
   3) `dp[from][to]`를 현재까지 계산된 최솟값과 새로운 값 중 최솟값으로 갱신. (`sum[to]-sum[from-1]`: 두 구간을 합치는 비용)

3. 최소비용은 `dp[1][K]`에 저장됨


### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int K = Integer.parseInt(br.readLine());
			int arr[] = new int[K+1];
			int sum[] = new int[K+1];
			int dp[][] = new int[K+1][K+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + arr[i];	// 비용 누적합 
			}
			
			for(int i=1; i<=K; i++) {
				for(int from=1; from+i<=K; from++) { // from ~ to 묶음
					int to = from+i;
					dp[from][to] = Integer.MAX_VALUE;
					for(int mid=from; mid<to; mid++) {	// 나누는 지점. (from ~ mid), (mid+1 ~ to) 묶음
						dp[from][to] = Math.min(dp[from][to], 
								dp[from][mid] + dp[mid+1][to] + sum[to] - sum[from-1]);
					}
				}
			}
			sb.append(dp[1][K]).append("\n");
		}
		System.out.println(sb);
	}
}

```

<br><br>


# 백준 15989. 1,2,3 더하기 4

### 문제 설명:

<p>정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 4가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 합을 이루고 있는 수의 순서만 다른 것은 같은 것으로 친다. 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.</p>

### 풀이:

<p>dp배열에 방법의 수를 저장. 순서만 다른 것은 같은 것으로 간주하므로, 중복이 없어야 함. 중복을 방지하기 위해서는 오름차순으로 더해져야 하므로 dp[i][1],dp[i][2],dp[i][3]로 나눠 각각 오름차순을 더함</p>

1. 방법의 수를 저장할 2차원 dp배열 `dp`생성. dp[i][j] = 합이 i인 식에서 제일 마지막에 더해진 수가 j인 경우의 수

2. 3 이하의 수는 각 경우의 수가 1개씩밖에 없으므로 1로 초기화

3. 중복 방지를 위해 `dp[i][1]`, `dp[i][2]`, `dp[i][3]` 각각에 오름차순으로 더한 경우의 수를 저장.

4. 1,2,3 각 경우의 수를 합친것이 최종 방법의 수(`dp[i][1] + dp[i][2] + dp[i][3]`)

### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		// dp[i][j] = 합이 i인 식에서 제일 마지막에 더해진 수가 j인 경우의 수
		int dp[][] = new int[10001][4];
		
		// 3이하의 수 초깃값 1
		dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
		
		// 중복방지-> 오름차순으로 더해져야 함.
		for(int i=4; i<=10000; i++) {
			dp[i][1] = dp[i-1][1];
			dp[i][2] = dp[i-2][1] + dp[i-2][2];
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());	
			sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");
		}
		System.out.println(sb);
	}
}
```

<br><br>


# 백준 1890. 점프

### 문제 설명:

<p>N×N 게임판에 수가 적혀져 있다. 이 게임의 목표는 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 점프를 해서 가는 것이다. 각 칸에 적혀있는 수는 현재 칸에서 갈 수 있는 거리를 의미한다. 반드시 오른쪽이나 아래쪽으로만 이동해야 한다. 0은 더 이상 진행을 막는 종착점이며, 항상 현재 칸에 적혀있는 수만큼 오른쪽이나 아래로 가야 한다. 한 번 점프를 할 때, 방향을 바꾸면 안 된다. 즉, 한 칸에서 오른쪽으로 점프를 하거나, 아래로 점프를 하는 두 경우만 존재한다. 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 이동할 수 있는 경로의 개수를 구하는 프로그램을 작성하시오.</p>

### 풀이:

<p>오른쪽으로 이동하는 경우와 아랫쪽으로 이동하는 경우를 각각 계산</p>

1. 게임판의 수를 저장할 배열 `arr`, 경로 개수의 최솟값을 저장할 2차원 dp배열 `dp` 생성 

2. 오른쪽으로 이동하는 경우 `dp[i+dist][j]`에 현재까지의 최솟값 더하기

3. 아랫쪽으로 이동하는 경우 `dp[i][j+dist]`에 현재까지의 최솟값 더하기

4. dp[N][N]에 최종 최솟값 저장됨.


### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main03 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N+1][N+1];
		long dp[][] = new long[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1] = 1;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int dist = arr[i][j];
				if(dist==0) break;
				
				if(i+dist<=N)	// 오른쪽으로 이동하는 경우
					dp[i+dist][j] += dp[i][j];
				if(j+dist<=N)	// 아랫쪽으로 이동하는 경우
					dp[i][j+dist] += dp[i][j];
			}
		}
		System.out.println(dp[N][N]);
	}
}
```

<br><br>



# 백준 12852. 1로 만들기 2

### 문제 설명:

<p>정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지이다.<br><br>
1. X가 3으로 나누어 떨어지면, 3으로 나눈다.<br>
2. X가 2로 나누어 떨어지면, 2로 나눈다.<br>
3. 1을 뺀다.<br><br>
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하고, N을 1로 만드는 방법에 포함되어 있는 수를 공백으로 구분해서 순서대로 출력한다. 정답이 여러 가지인 경우에는 아무거나 출력한다.
</p>

### 풀이:

<p>먼제 1을 뺀 경우의 횟수를 dp에 저장하고, 2로 나눴을 때, 또는 3으로 나눴을 때 더 작은 값을 가지면 그 값으로 갱신</p>

1. 연산 사용 횟수의 최솟값을 저장할 dp배열 `dp` 생성, 인덱스를 저장할 배열 `arr` 생성.

2. 2부터 N까지 순회하면서,
   1) 1을 뺀 경우의 연산사용횟수를 dp에 저장, 인덱스를 arr에 저장
   2) 3으로 나눌 경우의 연산사용횟수(`dp[i/3]+1`)가 갱신된 dp값보다 작을 경우, 3으로 나눴을 경우의 값으로 dp, arr 갱신
   3) 2로 나눌 경우도 마찬가지로 수행

3. dp[N]에 최종 횟수 저장됨. arr에 저장된 인덱스 이용해 연산에 포함된 모든 수 출력.


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
		int dp[] = new int[N+1];
		int arr[] = new int[N+1];	// 인덱스 저장용 배열
		
		for(int i=2; i<=N; i++) {
			// 1빼기
			dp[i] = dp[i-1] + 1;
			arr[i] = i-1;
			
			// 3으로 나누기
			if(i%3==0 && dp[i]>dp[i/3]+1) {
				dp[i] = dp[i/3] + 1;
				arr[i] = i/3; 
			}
			// 2로 나누기
			if(i%2==0 && dp[i]>dp[i/2]+1) {
				dp[i] = dp[i/2] + 1;
				arr[i] = i/2; 
			}
		}
		
		sb.append(dp[N]).append("\n");
		int idx = N;
		for(int i=0; i<=dp[N]; i++) {
			sb.append(idx).append(" ");
			idx = arr[idx];
		}
		System.out.println(sb);
	}
}
```

<br><br>
