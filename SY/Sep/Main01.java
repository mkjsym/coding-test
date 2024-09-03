// 2024.09.01
package SY.Sep;

/************* 10814. 나이순정렬 **************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main01 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		String [][] member = new String [N][2];
//		
//		for(int i=0; i<N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			member[i][0] = st.nextToken();
//			member[i][1] = st.nextToken();
//		}
//		Arrays.sort(member, (m1,m2)->{
//			int age1 = Integer.parseInt(m1[0]);
//			int age2 = Integer.parseInt(m2[0]);
//			
//			if(age1 == age2)
//				return 0;
//			else
//				return age1 - age2;
//		});
//		
//		for(int i=0; i<N; i++) {
//			sb.append(member[i][0]).append(" ")
//			.append(member[i][1]).append("\n");
//		}
//		System.out.print(sb);
//	}
//}


/************** 14425. 문자열집합 **************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main01 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap <String, Boolean> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), true);		
		}
		for(int i=0; i<M; i++) {
			if(map.containsKey(br.readLine()))
				cnt++;
		}
		System.out.println(cnt);
	}
}
