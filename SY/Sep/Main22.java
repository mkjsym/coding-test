// 2024.09.22
package SY.Sep;

/*********** 1037. 약수 **********/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main22 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
//		int N = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int min = Integer.MAX_VALUE;
//		int max = Integer.MIN_VALUE;
//		
//		for(int i=0; i<N; i++) {
//			int num = Integer.parseInt(st.nextToken());
//			min = Math.min(min, num);
//			max = Math.max(max, num);
//		}
//		System.out.println(min*max);
//	}
//}



/******* 25192. 인사성 밝은 곰곰이 ********/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main22 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
//		int N = Integer.parseInt(br.readLine());
//		
//		// 1. 곰곰티콘 집합
//		HashSet <String> set = new HashSet<>();
//		int cnt = 0;
//		
//		// 2. 첫번째 문자열은 무조건 "Enter" 
//		String chat = br.readLine();
//		
//		for(int i=0; i<N-1; i++) {
//			chat = br.readLine();
//			// 3. "Enter"가 들어오면 여태까지의 곰곰티콘 수를 저장하고 집합 초기화
//			if(chat.equals("ENTER")) {
//				cnt += set.size();
//				set.clear();
//				continue;
//			}
//			set.add(chat);
//		}
//		cnt += set.size();
//		System.out.println(cnt);
//	}
//}



/******** 26069. 붙임성 좋은 총총이 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main22 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		
		// 1. 무지개 댄스를 추는 사람의 집합
		HashSet <String> set = new HashSet<>();
		set.add("ChongChong");
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String first = st.nextToken();
			String second = st.nextToken();
			
			// 2. 만난 사람이 무지개 집합에 있으면 집합에 추가
			if(set.contains(first)) set.add(second);
			else if(set.contains(second)) set.add(first);
		}
		System.out.println(set.size());
	}
}