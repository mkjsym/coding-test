# 백준 2108. 통계학

### 문제 설명:

<p>산술평균(소숫점 이하 첫째 자리에서 반올림), 중앙값, 최빈값(여러개일 경우 두번째로 작은 값), 범위를 각 줄마다 출력하라.<br>
1) 산술평균 : N개의 수들의 합을 N으로 나눈 값<br>
2) 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값<br>
3) 최빈값 : N개의 수들 중 가장 많이 나타나는 값<br>
4) 범위 : N개의 수들 중 최댓값과 최솟값의 차이</p>

### 풀이:

빈도수: 배열에 수를 입력받으면서 HashMap에 (정수, 빈도)를 저장. 가장 높은 빈도를 저장해두고, hashmap을 순회하면서 가장 높은 빈도의 수를 List에 추가. List의 크기가 2가 되면 종료.<br>


1. 배열에 정수 저장, `HashMap`에 (정수, 빈도) 저장, `sum`에 누적합.

2. 산술평균: sum/N을 `Math.round`로 반올림

3. 중앙값: 정렬 후, 배열의 N/2번째 인덱스 값 출력

4. 최빈값: 가장 높은 빈도(HashMap의 value)를 `maxval`에 저장.
   HashMap을 순회하면서 value값이 `maxval`과 같으면 리스트에 추가. 최빈값이 여러개일 경우 두번째로 작은 값을 출력해야 하므로, 리스트의 사이즈가 2가 되면 종료

5. 범위: 배열의 마지막 인덱스 - 첫번째 인덱스 값

   
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
		int arr[] = new int[N];
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int sum = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			// HashMap에 (정수, 빈도) 저장
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}
			else {
				map.put(arr[i], 1);
			}
			
			sum += arr[i];
		}
		// 1. 산술평균
		sb.append(Math.round(sum/(double)N)).append("\n");
		
		// 2. 중앙값
		Arrays.sort(arr);
		sb.append(arr[N/2]).append("\n");
		
		// 3. 최빈값
		int maxval = Collections.max(map.values());
		ArrayList<Integer> maxkey = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			if(value == maxval) {
				maxkey.add(key);
				if(maxkey.size()==2) break;
			}
		}
		sb.append(maxkey.get(maxkey.size()-1)).append("\n");
		
		// 4. 범위
		sb.append(arr[N-1]-arr[0]);
		System.out.println(sb);
	}
}
```

<br><br>

# 백준 20920. 영단어 암기는 괴로워

### 문제 설명:

<p> 단어의 개수 N과 외울 단어 길이 기준 M이 주어진다. 길이가 M이상인 단어들만 외우고, 단어 순서를 다음과 같은 우선순위를 적용하여 단어장을 만든다.<br>
1. 자주 나오는 단어일수록 앞에 배치한다.<br>
2. 해당 단어의 길이가 길수록 앞에 배치한다.<br>
3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다.</p>

### 풀이:

`HashMap`에 빈도수 저장 -> `List`로 변환 후 정렬<br>

1. `HashMap`에 (단어, 빈도수) 저장. 길이가 M이상인 것만 저장함.

2. 단어목록(HashMap의 key)을 `List`에 넣기

3. sort 람다식에서 두 단어의 빈도수(HashMap의 value)를 각각 저장.

4. 빈도수가 같다면 단어의 길이를 비교 -> 길이가 같다면 사전순 정렬(`compareTo`), 다르면 길이순 정렬

5. 빈도수가 다르면 빈도수 정렬

** Arrays.sort -> 반환값이 양수: a1>a2 / 음수: a1<a2 / 0: a1==a2.  
-> a1-a2를 이용해 대소비교
   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main24 {
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> words = new HashMap<>();
		
		// 1. (단어,빈도수)를 HashMap에 넣기
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			if(str.length() >= M) {
				words.put(str, words.getOrDefault(str,0)+1);
			}
		}
		
		// 2. 단어목록을 리스트에 넣기
        ArrayList<String> wordList = new ArrayList<>(words.keySet());
		
        // 3. 정렬
        wordList.sort((w1, w2)->{
			int cnt1 = words.get(w1);
			int cnt2 = words.get(w2);
			
			if(cnt1 == cnt2) {
				if(w1.length() == w2.length())
					return w1.compareTo(w2);	// 사전순정렬
				else
					return w2.length() - w1.length();	// 길이정렬
			}
			else 
				return cnt2 - cnt1;		// 빈도수정렬
		});
		
		for(int i=0; i<wordList.size(); i++) {
			sb.append(wordList.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}

```

<br><br>

# 백준 4779. 칸토어 집합

### 문제 설명:

<p>칸토어집합: 구간 [0, 1]에서 시작해서 각 구간을 3등분하여 가운데 구간을 반복적으로 제외하는 방식으로 만듦.<br>
1. '-'가 $3^N$개 있는 문자열에서 시작한다.<br>
2. 문자열을 3등분 한 뒤, 가운데 문자열을 공백으로 바꾼다. 이렇게 하면, 선(문자열) 2개가 남는다.<br>
3. 이제 각 선(문자열)을 3등분 하고, 가운데 문자열을 공백으로 바꾼다. 이 과정은 모든 선의 길이가 1일때 까지 계속 한다.<br>
결과 문자열을 출력한다.</p>

### 풀이:

가운데 구간을 공백으로 변경하고, 첫번째 구간과 마지막 구간으로 나눠서 재귀호출<br>

1. '-' 문자열을 char 배열로 생성

2. (시작 인덱스, 총 길이)를 매개변수로 갖는 `Cantor`함수 생성

3. 가운데 구간을 공백으로 만들기 위해, 길이를 3등분한 값(한 토막의 길이)을 `divide`변수에 저장.  
(시작 인덱스+`divide`)부터 (시작인덱스+2*`divide`)까지가 가운데 구간. -> 이 구간을 공백으로 변경

4. 세등분 중, 가운데를 제외하고 첫번째 구간과 마지막 구간으로 나눠서 각각 재귀호출.

5. 총 길이가 1이 되면 종료

   
### 코드:

```java
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static char [] arr;
	public static void Cantor(int start, int len) {
		if(len == 1) return;
		
		// 가운데구간을 공백으로
		int divide = len / 3;
		for(int i=start+divide; i<start+(2*divide); i++) {
			arr[i] = ' ';
		}
		
		// 첫번째구간
		Cantor(start,divide);
		// 마지막구간
		Cantor(start+(2*divide),divide);
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String in;
		while((in = br.readLine()) != null) {
			int N = Integer.parseInt(in);
			int size = (int)Math.pow(3, N);
			arr = new char[size];
			for(int i=0; i<size; i++) {
				arr[i] = '-';
			}
			Cantor(0, size);
			for(char c: arr) 
				sb.append(c);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
```

<br><br>

# 백준 15650. N과 M (2)

### 문제 설명:

<p>N과 M이 주어진다. 1~N까지의 자연수 중, 중복없이 M개를 오름차순으로 고른 수열을 모두 구하여라.</p>

### 풀이:

1~N까지 중복 제외 모든 수 탐색 -> DFS(깊이우선탐색) 이용. dfs, bfs 공부하기<br>

1. `arr[]`: 고른 숫자 저장, `visit[]`: 노드 방문여부 저장 (초깃값: false)

2. 고른 숫자 개수(`depth`)를 매개변수로 가지는 `DFS`함수 생성

3. 모든 노드를 돌면서, 방문하지 않은 노드일 경우
   1) 방문상태로 변경
   2) 고른 숫자 저장(`arr[depth]`)
   3) depth를 1 증가시키고 재귀호출(다음 숫자 고르기)
   4) 재귀 종료 후, 다시 미방문상태로 복구

4. M개만큼 골랐으면(`depth==M`이면) 출력


 
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] arr;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void DFS(int depth) {
		// M개만큼 골랐으면 출력
		if(depth == M) {
			for(int a: arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 방문하지 않은 노드일 경우
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				// 오름차순일 경우만 숫자 저장
				if(depth!=0 && arr[depth-1] > i+1)
					continue;
				visit[i] = true;	
				arr[depth] = i+1;	
				DFS(depth+1);	
				visit[i] = false;	
			}
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visit = new boolean[N];

		DFS(0);
		System.out.println(sb);	
	}
}
```

<br><br>

# 백준 14888. 연산자 끼워넣기

### 문제 설명:

<p>개수가 N개인 수열 $A_1, A_2, ..., A_N$이 주어지고, 숫자 사이에 끼워넣을 수 있는 연산자(+, -, *, /)가 N-1개 주어진다. 숫자 사이에 연산자를 끼워넣어 식을 만들었을 때, 결과가 최대인 것과 최소인 것을 구하여라. 식의 계산은 연산자 우선순위를 무시하고 앞에서부터 진행한다.</p>

### 풀이:

숫자 개수를 depth로 해서 DFS함수 작성. 모든 경우의 수 탐색<br>

1. (계산값`num`, 숫자개수`depth`)를 매개변수로 가지는 `DFS`함수 생성

2. 연산자 개수가 0보다 클 경우,
   1) 연산자 개수 1 감소시킴.
   2) 연산자에 따라 계산을 달리해서 `DFS` 재귀호출.  
      매개변수: 1) 계산값`num`에 수열의 `depth`번째 값을 연산한 결과, 2) 개수`depth`를 1 증가시킨 것
   3) 재귀호출 종료시 연산자 개수 복구

3. 숫자 개수만큼 탐색했으면 최댓값, 최솟값 저장 후 종료

### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int K = 0;
	static int[] arr;
	static int[] op = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void DFS(int num, int depth) {
		// 숫자 개수만큼 탐색했으면 max,min 저장후 종료
		if(depth == arr.length) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		for(int i=0; i<4; i++) {
			// 연산자 개수 감소시키고(--) 재귀호출 종료시 복구(++)
			if(op[i]>0) {
				op[i]--;
				switch(i) {
					case 0: DFS(num + arr[depth], depth+1); break;
					case 1: DFS(num - arr[depth], depth+1); break;
					case 2: DFS(num * arr[depth], depth+1); break;
					case 3: DFS(num / arr[depth], depth+1); break;
				}
				op[i]++;
			}
		}
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		// 수열 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		// 연산자 개수 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(arr[0],1);
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}
}
```
