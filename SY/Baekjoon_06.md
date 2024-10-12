# 백준 1904. 01타일

### 문제 설명:

<p>1 하나만으로 이루어진 타일과, 0타일을 두 개 붙인 한 쌍의 00타일이 있다. 자연수 N이 주어졌을 때, 이 타일들로 만들 수 있는 길이가 N인 2진수열의 개수를 15746으로 나눈 나머지를 출력하라.</p>

### 풀이:

N값별로 개수를 나열해보면 1, 2, 3, 5, 8 ... 순으로 늘어남 -> 피보나치수열과 똑같은 점화식 사용. (dp[i] = dp[i-1] + dp[i-2])<br>
15746으로 나눈 나머지를 출력해야 함! 문제 제대로 읽고 풀기<br>


1. N+1개 크기의 dp배열 생성

2. 초깃값: `dp[0] = dp[1] = 1`

3. 점화식: `dp[i] = (dp[i-1] + dp[i-2]) % 15746` (15746으로 나눈 나머지값을 저장)

   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int dp[];
	public static int DP(int N) {
		dp[0] = dp[1] = 1;
		
		for(int i=2; i<=N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 15746;
		}
		return dp[N];
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		int result = DP(N);
		System.out.println(result);
	}
}
```

<br><br>


# 백준 1932. 정수삼각형

### 문제 설명:

<p>삼각형의 크기 n과 정수삼각형이 주어진다. 맨 위층부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 선택된 수들의 합의 최댓값을 구하여라. (아래층에 있는 수는 현재층에서 선택된 수의 왼쪽/오른쪽 대각선에 있는 것만 선택가능하다.)</p>

### 풀이:

삼각형 맨 아래부터 윗층으로 더해나가기. 두 수를 비교해서 더 큰 수를 윗층의 숫자와 더해 dp에 넣어줌.<br>

1. n*n크기의 2차원 dp배열 생성

2. 맨 아래층에서부터 윗층으로 더해나감  
   :현재층에서 선택된 수와, 그 수의 오른쪽에 있는 수 중 큰 값을 윗층의 수에 더함.

3. 최종적으로 dp[0][0]에 있는 수가 최댓값  


   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++)
				dp[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 두 수 비교해서 더 큰수를 윗층 숫자와 더함
		for(int i=n-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				dp[i-1][j] += Math.max(dp[i][j], dp[i][j+1]);
			}
		}
		
		System.out.println(dp[0][0]);
	}
}
```

<br><br>

# 백준 2579. 계단오르기

### 문제 설명:

<p>계단 아래 시작점부터 계단 꼭대기에 있는 도착점까지 가는 문제이다. 각각의 계단에 점수가 쓰여있고, 계단을 밟으면 그 계단에 적힌 점수를 얻게된다. 얻을 수 있는 점수의 최댓값을 구하여라.<br>
규칙:<br>
1. 계단은 한번에 한계단 또는 두 계단씩 오를 수 있다.<br>
2. 연속된 세 개의 계단을 모두 밟으면 안된다. (시작점은 계단에 포함X)<br>
3. 마지막 도착 계단은 반드시 밟아야 한다.</p>

### 풀이:

연속된 세개의 계단을 모두 밟으면 안되므로 계단오르는 방식은  
(n-2) -> n  
(n-3) -> (n-1) -> n  
이 두가지 뿐임.<br>

1. 계단 점수를 담을 arr 배열과, 최댓값을 담을 dp 배열 생성

2. 초기값: 첫번째 계단은 계단 점수 그대로.(`dp[0]=arr[0]`)  
   두번째 계단은 첫번째+두번째 계단을 모두 밟아야 최대(`dp[1] = arr[0] + arr[1]`)  
   세번째 계단은 첫번째, 두번째 계단 중 점수가 더 큰 계단 + 세번째 계단을 밟아야 최대(`dp[2] = Math.max(arr[0], arr[1]) + arr[2]`)

3. 네번째 계단부터 반복문으로 dp배열에 최댓값 넣기  
   : ((n-2)번째까지의 점수)와 ((n-3)번째까지의 점수+ (n-1)번째 계단점수) 중 더 큰 값 + 현재 계단 점수  

4. 최종적으로 dp의 마지막 수가 최댓값이 됨.

 
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int dp[] = new int[n];
		
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		dp[0] = arr[0];
		if(n>=2) dp[1] = arr[0] + arr[1];
		if(n>=3) dp[2] = Math.max(arr[0], arr[1]) + arr[2];

		for(int i=3; i<n; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+arr[i-1]) + arr[i];
		}
		System.out.println(dp[n-1]);
	}
}
```

<br><br>

# 백준 1149. RGB거리

### 문제 설명:

<p>1~N번 집이 순서대로 있다. 각각의 집을 빨강,초록,파랑으로 칠하는 비용이 주어졌을 때, 모든 집을 칠하는 비용의 최솟값을 구하여라.<br>
규칙:<br>
1. 1번집은 2번집의 색과 같지 않아야 한다.<br>
2. N번 집은 N-1번 집의 색과 같지 않아야 한다.<br>
3. i(2 <= i <= N-1)번 집은 i-1번, i+1번 집의 색과 같지 않아야 한다.</p>

### 풀이:

r,g,b 각각의 경우에서의 최솟값을 dp에 저장. r,g,b 각각의 비용 + 이전 집들의 최솟값을 구해 저장하는 방식.<br>

1. n행 3열의 2차원 배열 arr 생성

2. 마지막 집까지 반복문을 돌리면서,
   1) 만약 첫번째 집이면 `continue`
   2) r,g,b 각각의 경우에 이전 집의 최솟값을 더해줌.
      ex) i번째 집을 r로 칠할 경우: i-1번째 집은 g,b 중 하나. -> g,b 중 더 작은 값 + i번째 집을 r로 칠하는 비용 `arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2])`

### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			if(i==0) continue;
			// r,g,b 각각을 선택하는 경우 + 이전 집의 최솟값
			arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);	// r
			arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);	// g
			arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]);	// b
		}
		
		int result = Math.min(Math.min(arr[N-1][0],arr[N-1][1]),arr[N-1][2]);
		System.out.println(result);
	}
}
```
