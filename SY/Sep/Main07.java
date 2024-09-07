package SY.Sep;

/************** 1269. 대칭 차집합 **************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main07 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int A = Integer.parseInt(st.nextToken());
//		int B = Integer.parseInt(st.nextToken());
//		int intersection = 0;
//		Set <Integer> Union = new HashSet<>();
//		
//		// 1. A와 B의 합집합 (set 이용) 
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<A; i++) {
//			Union.add(Integer.parseInt(st.nextToken()));
//		}
//		
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<B; i++) {
//			int num = Integer.parseInt(st.nextToken());
//			
//			// 2. 교집합의 수 세기
//			if(Union.contains(num)) {
//				intersection++;
//				continue;
//			}
//			Union.add(num);
//		}
//		
//		// 3. 합집합 - 교집합
//		int answer = Union.size() - intersection;
//		System.out.println(answer);		
//	}
//}


/************ 11478. 서로 다른 부분 문자열의 개수 ***********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main07 {
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