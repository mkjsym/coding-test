# 백준 11053. 가장 긴 증가하는 부분 수열

### 문제 설명:

<p>수열이 주어질 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오. 예를 들어, {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 {10, 20, 30, 50} 이고, 길이는 4이다.</p>

### 풀이:

수열을 순회하면서, 현재숫자가 이전숫자보다 크면(증가하는 수열이면) 현재숫자를 마지막값으로 하는 수열 중 가장 긴 길이를 저장하는 방식으로<br>

1. 수열을 담을 배열 `arr`과, 길이를 담을 배열 `dp`생성(초깃값: 1)

2. 이중 for문으로 수열 순회:
   1) 첫번째 for문: 전체 수열 순회
   2) 두번째 for문: i번째까지의 수열 순회
  
3. 증가하는 수열일 경우에만 dp에 길이 갱신. 현재숫자를 마지막값으로 하는 수열 중 가장 긴 길이를 dp에 저장

4. 전체수열을 계속 순회하면서 가장 긴 값을 max에 저장

### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr [] = new int[n];
		int dp [] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		int max = 1;
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				// arr[i]를 마지막값으로 하는 수열 중 가장 긴 길이를 dp에 저장
				if(arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
```

<br><br>


# 백준 12865. 평범한 배낭

### 문제 설명:

<p>물품의 수 N과 배낭이 버틸 수 있는 무게 K가 주어지고, 각 물건의 무게 W와 가치 V가 주어진다. 배낭에 넣을 수 있는 가치합의 최댓값을 출력하라.</p>

### 풀이:

물품 무게 W에서 넣을 수 있는 가치의 최댓값을 dp에 저장하는 방식<br>


1. 물품별 [무게W, 가치V]를 저장할 2차원 배열 `stuff` 생성. 

2. 가치합을 저장할 [N+1][K+1]크기의 2차원 배열  `dp` 생성

3. 물품의 무게가 배낭의 무게를 넘지 않는 경우에  
   이전 가치합 vs 현재물품의 가치 + (최대무게-현재무게)번째의 가치합 중 큰 값을 dp에 갱신

4. 물품의 무게가 배낭의 무게를 넘으면 dp에 저장된 이전 가치합을 그대로 사용

   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int stuff[][] = new int[N+1][2];	// [W,V]
		int dp[][] = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			stuff[i][0] = Integer.parseInt(st.nextToken());	// W
			stuff[i][1] = Integer.parseInt(st.nextToken());	// V
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {	
				if(j - stuff[i][0] >= 0)
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stuff[i][0]] + stuff[i][1]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		System.out.println(dp[N][K]);
	}
}
```

<br><br>


# 백준 1931.회의실 배정

### 문제 설명:

<p>회의의 수 N이 주어지고, 각 회의의 시작시간과 종료시간이 주어진다. 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 출력하라.</p>

### 풀이:

종료시간이 빠를수록 더 많은 회의를 할 수 있음. -> 종료시간 빠른순으로 정렬(종료시간이 같으면 시작시간 빠른순 정렬)해서 회의의 시작시간이 이전회의의 종료시간 이후인 경우에만 회의 수를 count해줌.<br>

   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		// 종료시간 빠른 순 정렬. 종료시간 같으면 시작시간 빠른순
		Arrays.sort(arr, (o1, o2)->{
			if(o1[1] == o2[1])
				return o1[0]-o2[0];
			else
				return o1[1]-o2[1];
		});
		
		int cnt = 1;
		int end = arr[0][1];
		// 시작시간 >= 이전회의 종료시간인 경우만 count
		for(int i=1; i<N; i++) {
			if(arr[i][0] >= end) {
				end = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
```

