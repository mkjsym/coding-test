# 백준 7785. 회사에 있는 사람

### 문제 설명:

<p>출퇴근 로그가 주어졌을 때, 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 출력한다.</p>

### 풀이:

`List`는 시간초과. `TreeMap`(정렬된 map) 이용<br>

1. `TreeMap` 생성.<br>
생성시 `Comparator.reverseOrder` 로 내림차순 정렬하도록 설정.

2. 출근: `map.put(이름)`, 퇴근: `map.remove(이름)`

3. map에 남아있는 명단 출력

### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		TreeMap <String, String> map = new TreeMap<>(Comparator.reverseOrder());
		
		// 1. 출근: 기록, 퇴근: 삭제
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String exist = st.nextToken();
			
			if(!map.containsKey(name))
				map.put(name, exist);
			else
				map.remove(name);
		}
		
		// 2. 남은 명단 전체 출력
		for(Map.Entry<String,String> entry: map.entrySet()) {
			sb.append(entry.getKey()).append("\n");
		}
		System.out.print(sb);
	}
}
```

<br><br>

# 백준 1620. 나는야 포켓몬 마스터 이다솜

### 문제 설명:

<p>도감에 수록된 포켓몬의 이름 N개와, 맞춰야하는 문제 M개가 주어진다. 입력으로 숫자가 들어오면 그 해당 번호의 포켓몬 이름을, 문자가 들어오면 해당 포켓몬의 번호를 출력한다.</p>

### 풀이:

`LinkedHashMap`(입력 순서대로 저장되는 map) 이용<br>

1. `LinkedHashMap`에 도감 작성. (key: 이름, value: 번호)

2. 포켓몬 도감을 `ArrayList`에 넣어줌

3. 주어진 문제의 첫글자가 알파벳이면 해당 포켓몬의 번호(value) 출력

4. 문제가 숫자이면 리스트에서 해당 인덱스에 있는 이름 출력.  
   리스트의 인덱스는 0부터 시작하므로 -1 해줌
   
### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 1. 도감 작성
		LinkedHashMap <String,Integer> doc = new LinkedHashMap<>();
		for(int i=1; i<=N; i++) {
			doc.put(br.readLine(), i);
		}
		
		// 2. 정답 출력
		ArrayList <String> docList = new ArrayList<>(doc.keySet());
		for(int i=0; i<M; i++) {
			String problem = br.readLine();
			if(problem.charAt(0) >= 'A')
				sb.append(doc.get(problem)).append("\n");
			else
				sb.append(docList.get(Integer.parseInt(problem)-1)).append("\n");
		}
		System.out.println(sb);
	}
}
```


<br><br>

# 백준 18870. 좌표압축

### 문제 설명:

<p>N개의 x좌표에 대하여 좌표압축을 적용한 결과를 출력한다.</p>
<p>($X_i$를 좌표압축한 결과는 $X_i$ > $X_j$를 만족하는 서로 다른 좌표 $X_j$의 개수와 같다.)</p>

### 풀이:

결과값은 오름차순으로 정렬된 x값의 순번과 같음.<br>
`TreeMap`(중복제거 & 정렬) + `array`(x값을 입력순서대로 저장) 이용<br>

1. `TreeMap`에 값 넣기. (key: x값, value: 좌표압축결과)  
   처음에는 value에 초깃값으로 0을 넣음.

2. x값들을 입력 순서대로 저장하기 위해 `array`에 x값 넣기.

3. 정렬된 모든 keySet값을 순회하면서 key값의 순번을 차례로 value에 넣어줌.

4. `array`를 순회하면서 `TreeMap`에 접근해, 맵에서 x값이 가진 순번을 출력

### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		TreeMap <Integer, Integer> map = new TreeMap<>();
		int [] arr = new int[N];
		
		// 1. 값 넣기
		for(int i=0; i<N; i++) {	
			int num = Integer.parseInt(st.nextToken());
			map.put(num, 0);
			arr[i] = num;
		}
		
		// 2. map의 value에 정렬 결과 넣기
		int j=0;
		for(int key: map.keySet()) {
			map.put(key, j++);
		}
		
		// 3. 결과값 출력
		for(int i=0; i<N; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.println(sb);
	}
}
```

<br><br>

# 백준 1764. 듣보잡

### 문제 설명:

<p>듣도 못한 사람 N명의 이름과 보도 못한 사람 M명의 이름이 주어질 때, 듣도 보도 못한 사람의 수와 명단을 사전 순으로 출력한다.</p>

### 풀이:

`HashMap` + `TreeMap`(정렬된 map) 이용<br>

1. `HashMap`에 듣도 못한 사람 명단 넣기.

2. 보도 못한 사람의 이름이 `HashMap`에 존재한다면 `TreeMap`에 이름 넣기.

3. `TreeMap`에 있는 값의 개수와 명단 출력

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
		HashMap<String,Boolean> people = new HashMap<>();
		TreeMap<String,Boolean> result = new TreeMap<>();
		
		// 1. HashMap: 듣도 못한 사람
		for(int i=0; i<N; i++) {
			people.put(br.readLine(), true);
		}
		
		// 2. TreeMap: 듣도+보도 못한 사람(정렬됨)
		for(int i=0; i<M; i++) {
			String name = br.readLine();
			if(people.get(name) != null) {
				result.put(name, true);
			}
		}
		
		// 3. 듣도 보도 못한 사람 명단 출력
		sb.append(result.size()).append("\n");
		for(String s: result.keySet()) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}
```

<br><br>

# 백준 1269. 대칭 차집합

### 문제 설명:

<p>집합 (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합이라고 한다. 대칭차집합의 원소의 개수를 출력하여라.</p>

### 풀이:

대칭 차집합: (A와 B의 합집합) - (교집합)<br>
`HashSet`을 이용해 합집합을 구하고, 교집합의 개수만큼을 뺌.

1. `HashSet`에 A의 원소를 넣음.

2. `HashSet`에 B의 원소가 존재하면 교집합이므로 개수 count

3. `HashSet`에 B의 원소를 넣음.

4. `HashSet`(합집합)의 원소 수 - 교집합 수 출력.

### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int intersection = 0;
		Set <Integer> Union = new HashSet<>();
		
		// 1. A와 B의 합집합 (set 이용) 
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<A; i++) {
			Union.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<B; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// 2. 교집합의 수 세기
			if(Union.contains(num)) {
				intersection++;
				continue;
			}
			Union.add(num);
		}
		
		// 3. 합집합 - 교집합
		int answer = Union.size() - intersection;
		System.out.println(answer);		
	}
}
```

<br><br>

# 백준 11478. 서로 다른 부분 문자열의 개수

### 문제 설명:

<p>문자열 S의 서로 다른 부분 문자열의 개수를 출력한다.</p>

### 풀이:

1. `substring`으로 부분문자열을 추출.

2. 추출한 부분문자열을 `HashSet`에 넣어 중복 제거.

3. `HashSet`에 있는 부분문자열의 개수를 출력.

### 코드:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		HashSet <String> strSet = new HashSet<>();

		for(int i=0; i<str.length(); i++) {
			for(int j=i+1; j<=str.length(); j++) {
				strSet.add(str.substring(i,j));
			}
		}
		System.out.println(strSet.size());
	}
}
```
