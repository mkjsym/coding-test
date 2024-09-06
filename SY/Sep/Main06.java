// 2024.09.06
package SY.Sep;

/*********** 1764. 듣보잡 ***********/
/*
 * HashMap + TreeMap(정렬) 이용 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main06 {
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