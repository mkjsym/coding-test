# 백준 10844. 쉬운 계단 수

### 문제 설명:

<p>45656과 같이 인접한 모든 자리의 차이가 1인 수를 계단수라고 한다. 0으로 시작하는 수는 계단수가 아니다. N(1 <= N <= 100)이 주어질 때, 길이가 N인 계단수의 총 개수를 1,000,000,000으로 나눈 나머지를 출력하여라.</p>

### 풀이:

Bottom-up 방식으로 길이별로 가지는 계단수 개수를 배열에 누적. 숫자가 0이면 바로 전에 올 수 있는 계단수는 1뿐, 숫자가 9이면 바로 전에 올 수 있는 계단수는 8뿐. 이외의 경우에는 1 차이나는 수들이 계단수. -> 이전 길이에서 누적했던 계단수 개수를 이용하여 구함. <br>
long 타입으로 선언해야 함. 연산할 때마다 % mod 해줘야 범위초과 안됨.<br>

1. [길이+1][10]의 크기를 가지는 배열 `arr` 생성

2. 길이가 1인 경우는 계단수를 1~9까지 한 개 씩 가지므로 arr[1][i]번째에 1 할당.

3. i= 길이 2부터 N까지 돌면서 0~9까지의 숫자 각각이 가지는 계단수 개수 넣어줌.

   1) 현재 숫자가 0인 경우: 이전 길이(i-1)의 숫자 1이 가지는 개수와 같음.

   2) 현재 숫자가 9인 경우: 이전 길이(i-1)의 숫자 8이 가지는 개수와 같음.

   3) 그 외: 이전 길이(i-1)에서 (현재숫자-1) + (현재숫자+1)의 개수

4. 마지막 N번째에서 0~9까지의 합을 구함

### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long mod = 1000000000;
		long arr[][] = new long[N+1][10];
		
		// 길이 1인 경우
		for(int i=1; i<=9; i++) {
			arr[1][i] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=9; j++) {
				if(j==0) {
					arr[i][j] = arr[i-1][1] % mod;
				}
				else if(j==9) {
					arr[i][j] = arr[i-1][8] % mod;
				}
				else {
					arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1])% mod;
				}
			}
		}
		
		long result = 0;
		for(int i=0; i<=9; i++) {
			result += arr[N][i]; 
		}
		System.out.println(result % mod);
	}
}
```

<br><br>


# 백준 16139. 인간-컴퓨터 상호작용

### 문제 설명:

<p>문자열 S와, 특정 알파벳 a, 문자열의 구간 [l,r]이 주어진다. S의 l번째 문자부터 r번째 문자 사이에 a가 몇 번 나타나는지 구하여라.</p>

### 풀이:

a-z까지 알파벳별 등장횟수를 누적합한 후 구간합 구하기.<br>


1. 알파벳별 등장횟수를 저장할 [26][문자열길이]크기의 배열 `alArr` 생성

2. 알파벳 별로 등장횟수 누적합을 저장. (배열의 인덱스는 a:0, ..., z:25)

3. 알파벳 `a`의 구간합 구하기

   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		int q = Integer.parseInt(br.readLine());
		int alArr[][] = new int[26][S.length()+1];
		
		// 알파벳 별 누적합 구하기
		for(int i=1; i<=S.length(); i++) {
			for(int j=0; j<26; j++) {
				alArr[j][i] = alArr[j][i-1];
			}
			int idx = S.charAt(i-1) - 97;
			alArr[idx][i]++;
		}
		
		for(int i=0; i<q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			// 구간합 구하기
			int result = alArr[a-97][r+1] - alArr[a-97][l];
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
```

<br><br>


# 백준 11660. 구간합구하기5

### 문제 설명:

<p>NxN개의 수가 NxN 크기의 표에 채워져있다. (x1,y1) ~ (x2,y2)까지 합을 구하여라. (x:행, y:열)</p>

### 풀이:

배열에 누적합하고, (x2,y2)까지의 누적합에서 구간 이외의 부분은 빼줌. -> 구간 이외의 부분인 (0,0) ~ (x2,y1-1)과 (0,0) ~ (x1-1,y2)구간을 빼주고, 중복해서 뺀 부분인 (0,0) ~ (x1-1,y1-1)은 다시 더해줌. 뺄 부분을 그려서 색칠해봐야 쉬움..<br>

1. [N+1][N+1]크기의 배열 `arr` 생성

2. `arr`에 누적합 저장: 이전 행,열 값을 현재 값에 더하고, 중복으로 더해진 부분 빼주기.

3. (x2,y2)까지 누적합한 결과에서 구간 이외의 부분을 빼주고, 중복해서 뺀 부분은 다시 더해줌.


   
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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			// 블록단위로 누적합하고 교집합 빼주기
			for(int j=1; j<=N; j++) {
				arr[i][j] = arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// 구간 이외의 부분 빼주고, 중복해서 뺀 부분은 더해줌
			int result = arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1];
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
```

<br><br>

# 백준 10986. 나머지 합

### 문제 설명:

<p>수 N개 $A_1, A_2, ..., A_N$이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하여라.</p>

### 풀이:

(i,j)구간의 누적합은 `sum[j] - sum[i-1]`. `(sum[j] - sum[i-1]) % M = 0`인 것을 구해야 함.<br>
분배법칙 -> `sum[j]%M - sum[i-1]%M = 0` -> `sum[j]%M = sum[i-1]%M`<br>
=> mod M 연산값이 같은 것들을 구하면 됨.<br>
결과값은 long타입으로 선언해야 범위초과안됨.<br>

1. 나머지 별 개수를 담을 크기가 M인 배열 `cnt` 생성

2. 수열의 끝까지 순회하면서 누적합 % M 연산 -> 나머지를 배열`cnt`의 인덱스로 하여 해당 나머지의 개수 +1

3. mod M  = 0인 경우는 쌍을 찾을 필요 x. 그대로 `result`값에 넣음.

4. 나머지 별 개수를 저장한 배열 `cnt`를 순회하면서,
   mod M 값이 같은 것 중 두 개를 고르는 경우의 수(nC2 조합) 더하기

 
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
		int M = Integer.parseInt(st.nextToken());
		int cnt[] = new int[M];
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			sum = (sum + Integer.parseInt(st.nextToken())) % M;
			// mod M 값이 같은 것의 수 세기
			cnt[sum]++;
		}
		
		// mod M = 0인 경우의 개수
		long result = cnt[0];
		
		// mod M 값이 같은 것 중 두개를 고르는 경우의수(nC2 조합) 더하기
		for(int i=0; i<M; i++) {
			result += (long)cnt[i]*(cnt[i]-1)/2;
		}
		System.out.println(result);
	}
}
```
