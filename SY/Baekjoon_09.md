# 백준 9251. LCS

### 문제 설명:

<p>LCS문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다. 두 문자열의 LCS의 길이를 출력하라.</p>

### 풀이:

표에 표시하면서 규칙 찾기. 문자가 같으면 왼쪽 위 대각선 값+1, 다르면 max(왼쪽,윗쪽)<br>

|   	| A 	| C 	| A 	| Y 	| K 	| P 	|
|---	|---	|---	|---	|---	|---	|---	|
| C 	| 0 	| 1 	| 1 	| 1 	| 1 	| 1 	|
| A 	| 1 	| 1 	| 2 	| 2 	| 2 	| 2 	|
| P 	| 1 	| 1 	| 2 	| 2 	| 2 	| 3 	|
| C 	| 1 	| 2 	| 2 	| 2 	| 2 	| 3 	|
| A 	| 1 	| 2 	| 3 	| 3 	| 3 	| 3 	|
| K 	| 1 	| 2 	| 3 	| 3 	| 4 	| 4 	|

1. 문자열 길이+1만큼씩의 크기를 가지는 2차원 배열 dp 생성

2. dp를 순회하면서, 문자가 같을 경우, 왼쪽 위 대각선 값 +1 을 저장

3. 문자가 다를 경우, 왼쪽값과 윗쪽값 중 더 큰 값을 저장
   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int len1 = s1.length();
		int len2 = s2.length();
		int dp[][] = new int[len1+1][len2+1];
	
		for(int i=1; i<=len1; i++) {
			for(int j=1; j<=len2; j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[len1][len2]);
	}
}

```

<br><br>


# 백준 2447. 별찍기-10

### 문제 설명:

<p> N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다. 크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다. N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 별을 출력하여라</p>

### 풀이:

<p>N==1까지 분할해서 1개씩 별찍기</p>

1. [N][N]크기의 star 배열은 모두 공백으로 초기화

2. N을 3으로 나누면서 가운데 부분(1,1)은 그대로 공백으로 두고, 재귀호출을 통해 더 작은 부분으로 분할.
   (매개변수 x : 현재 x값에 i*N값 더한 좌표)

4. N이 1이 되면 해당 위치에 별을 찍어줌.

### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char star[][];

	public static void stars(int N, int x, int y) {
		// N==1이면 더이상 분할하지 X
		if(N==1) {
			star[x][y] = '*';
			return;
		}
		N /= 3;
		
		// 가운데부분(1,1) 공백으로. 
		// stars() 재귀호출-> 더 작은 부분으로 분할하기
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i==1 && j==1) {
					continue;
				}
				stars(N, x+i*N, y+j*N);
			}
		}
		
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		star = new char[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				star[i][j] = ' ';
			}
		}
		stars(N,0,0);
		
		// 출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}


```

<br><br>


# 백준 11729. 하노이 탑 이동순서

### 문제 설명:

<p>세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다. 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.<br><br>
1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.<br>
2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.<br><br>
이 작업을 수행하는데 필요한 최소 이동 순서를 출력하고, 두 정수 A B를 출력하라. (A번째 탑 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻)</p>

### 풀이:

<p>원판들을 start -> mid로 이동시키고, start에 있는 원판을 end로 이동시킨다. 그런 다음 원판들을 mid -> end로 이동시킨다. 만약 원판이 하나 남으면 바로 end로 이동시킨다.</p>

1. 재귀호출을 통해 N-1개의 원판들을 start -> mid로 이동시킨다.

2. start에 있는 원판을 end로 이동시킨다(출력)

3. 재귀호출을 통해 N-1개의 원판들을 mid -> end로 이동시킨다.

4. 원판이 1개 남았으면 end로 이동시킨다.(출력 후 return)

### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int K=0;
	public static void hanoi(int N, int start, int mid, int end) {
		K++;
		// 원판이 하나남은 경우 바로 start->end로 이동
		if(N==1) {
			sb.append(start + " " + end).append("\n");
			return;
		}
				
		hanoi(N-1,start,end,mid);	// 원판들을 mid로 이동
		sb.append(start + " " + end).append("\n");
		hanoi(N-1,mid,start,end);	// 원판들을 mid->end로 이동
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hanoi(N,1,2,3);
		System.out.println(K);
		System.out.println(sb);
	}
}


```

<br><br>


# 백준 1629. 곱셈

### 문제 설명:

<p>자연수 A를 B번 곱한 수를 C로 나눈 나머지를 구하여라. (A,B,C는 2,147,483,647 이하의 자연수)</p>

### 풀이:

<p>지수가 1이 될 때까지 절반으로 분할해서 곱하고, 지수가 홀수일 때는 A를 한번더 곱해줌. ex) $A^5 = (A^2*A^2)*A = ((A^1*A^1)*(A^1*A^1))*A$ <br>
(A * B) mod C = (A mod C * B mod C) modC 성질 이용 -> 곱할때마다 mod 연산 해줌. </p>

1. 제곱연산을 수행하는 함수 Divide 생성. (long 타입)

2. 지수가 1이 될 때까지 지수를 절반으로 분할하고, 만약 지수가 1이 되면 A mod C를 그대로 반환

3. 분할해서 곱한 수 반환. 곱셈마다 mod연산해주기.
    
4. 지수가 홀수이면 A%C를 한 번 더 곱해줌.

### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static long A, C;
	public static long Divide(long b) {
		if(b==1)	// 지수가 1이 될 때까지 분할
			return A%C;
		
		long divNum = Divide(b/2);
		if(b%2 == 1) // 지수가 홀수일 때: 같은 지수로 맞춰주고 한번 더 곱하기
			return (divNum*divNum % C) * A%C;
		else
			return divNum*divNum % C;
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(Divide(B));
	}
}

```

<br><br>


# 백준 11401. 이항계수 3

### 문제 설명:

<p>자연수 N과 정수 K가 주어졌을 때 이항계수 (N K)를 1,000,000,007로 나눈 나머지를 구하여라. (1 <= N <= 4,000,000), (0 <= K <= N)</p>

### 풀이:

nCk = n!/k!*(n-1)!<br>
mod 연산의 성질 (A * B) mod C = (A mod C * B mod C) modC은 나눗셈에는 성립 X -> 나눗셈을 곱셈 형태로 바꿔줘야 함-> 분모의 역원 구하기<br>
역원 구하는 방법: 페르마의 소정리 이용. ${a^p}\equiv{a}\pmod{p}$ -> ${a^p-1}\equiv{1}\pmod{p}$ -> ${a * a^{p-2}}\equiv{1}\pmod{p}$<br>
역원: ${a^{p-2}}\pmod{p}$ <br>


1. 분자: N!, 분모: K!*(N-1)! 계산하기

2. 분모의 역원 구하기: a^(p-2) 계산

3. [1629. 곱셈]과 같은 방식으로 곱셈 분할정복

   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static long mod = 1000000007;
	
	// 거듭제곱 분할함수. a는 밑, b는 지수
	public static long Divide(long a, long b) {
		if(b==1)
			return a%mod;
		
		long num = Divide(a, b/2);
		
		if(b%2==1) {
			return (num*num%mod) * a%mod;
		}
		else {
			return num*num%mod;
		}
	}
		
	public static long factorial(long n) {
		long num = 1;
		for(long i=2; i<=n; i++) {
			num = (num*i) % mod;
		}
		return num;
	}
	
		
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		// 분모 N!
		long num = factorial(N)%mod;
		
		// 분자 (K! * (N-1)!) % mod
		long denum = factorial(K)*factorial(N-K)%mod;
		
		// 분자의 역원
		long result = num * Divide(denum,mod-2) % mod;
		
		System.out.println(result);
	}
}

```
