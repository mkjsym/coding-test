// 2024.09.18
package SY.Sep;

/********** 1929. 소수 구하기 **********/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main18 {
//	public static void main(String [] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int M = Integer.parseInt(st.nextToken());
//		int N = Integer.parseInt(st.nextToken());
//		
//		for(int i=M; i<=N; i++) {
//			if(i==1) continue;
//			Boolean isPrime = true;		
//			for(long j=2; j<=Math.sqrt(i); j++) {
//				if(i%j==0) {
//					isPrime = false;
//					break;
//				}
//			}
//			if(isPrime)
//				sb.append(i).append("\n");
//		}
//		System.out.println(sb);
//	}
//}


/****** 15439. 베라의 패션 ******/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main18 {
//	public static void main(String [] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		System.out.println(N*(N-1));
//	}
//}

/***** 24723. 녹색거탑 *****/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main18 {
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println((int)Math.pow(2,N));	// Math.pow는 double형
	}
}