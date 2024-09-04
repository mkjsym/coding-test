// 2024.09.04
package SY.Sep;

/************* 10815. 숫자 카드 **************/
/*
 * HashMap 이용. ArrayList 시간초과. 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main04 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String,Boolean> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. 가진 카드를 map에 넣기
		for(int i=0; i<N; i++) {
			map.put(st.nextToken(), true);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		// 2. 값이 존재하면 1, 아니면 0
		for(int i=0; i<M; i++) {
			if(map.get(st.nextToken())!=null) 
				sb.append(1).append(" ");
			else
				sb.append(0).append(" ");
		}
		System.out.println(sb);
	}
}