// 2024.08.24
package SY;

/************** 2798. 블랙잭 **************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main7 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		st = new StringTokenizer(br.readLine());
//		int [] card = new int[N];
//		int sum=0, cards=0;
//		
//		for(int i=0; i<N; i++)
//			card[i] = Integer.parseInt(st.nextToken());
//
//		for(int i=0; i<card.length-2; i++) 
//			for(int j=i+1; j<card.length-1; j++) 
//				for(int k=j+1; k<card.length; k++) {
//					cards = card[i]+card[j]+card[k];
//					if(cards <= M)
//						sum = Math.max(sum, cards);
//				}
//		System.out.println(sum);
//	}
//}



/************** 2231. 분해합 ***************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main7 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int answer = 0;
//		
//		for(int i=1; i<=N; i++) {
//			int sum = 0;
//			String num = String.valueOf(i);
//			for(int j=0; j<num.length(); j++)
//				sum += num.charAt(j)-'0';
//
//			if(sum+i == N) {
//				answer = i;
//				break;
//			}
//		}
//		System.out.println(answer);
//	}
//}



/****** 24262. 알고리즘의 수행시간1 *******/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main7 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		
//		System.out.println(1);	
//		System.out.println(0);	// O(1)
//	}
//}



/****** 24262. 알고리즘의 수행시간2 *******/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main7 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		
//		System.out.println(n);
//		System.out.println(1);	// O(n)
//	}
//}



/****** 24262. 알고리즘의 수행시간3 *******/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main7 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		long n = Long.parseLong(br.readLine());
//		
//		System.out.println(n*n);
//		System.out.println(2);	// O(n^2)
//	}
//}



/****** 24262. 알고리즘의 수행시간4 *******/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main7 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		System.out.println(n*(n-1)/2);
		System.out.println(2);	// O(n^2)
	}
}