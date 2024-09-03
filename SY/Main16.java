// 2024.09.02
package SY;

/************** 7785. 회사에 있는 사람 **************/
/*
 * TreeMap 이용(정렬된 map). List는 시간초과
 * Comparator.reversOrder로 내림차순정렬
 */
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Comparator;
//import java.util.TreeMap;
//import java.util.Map;
//import java.util.StringTokenizer;
//
//public class Main16 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		TreeMap <String, String> map = new TreeMap<>(Comparator.reverseOrder());
//		
//		// 1. 출근 기록, 퇴근 삭제
//		for(int i=0; i<N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			String name = st.nextToken();
//			String exist = st.nextToken();
//			
//			if(!map.containsKey(name))
//				map.put(name, exist);
//			else
//				map.remove(name);
//		}
//		
//		// 2. 남은 명단 전체 출력
//		for(Map.Entry<String,String> entry: map.entrySet()) {
//			sb.append(entry.getKey()).append("\n");
//		}
//		System.out.print(sb);
//	}
//}



/*********** 1620. 나는야 포켓몬 마스터 이다솜 ************/
/*
 * LinkedHashMap (입력순서대로 저장되는 map) 이용
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main16 {
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
