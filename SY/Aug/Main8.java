// 2024.08.25
package SY.Aug;

/********** 24266. 알고리즘의 수행 시간 5 **********/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main8 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		long n = Long.parseLong(br.readLine());
//		
//		System.out.println(n*n*n);
//		System.out.println(3);	// O(n^3)
//	}
//}



/******** 24313. 알고리즘수업- 점근적 표기1 ********/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main8 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int a1 = Integer.parseInt(st.nextToken());
//		int a0 = Integer.parseInt(st.nextToken());
//		int c = Integer.parseInt(br.readLine());
//		int n0 = Integer.parseInt(br.readLine());
//		
//		if(a0 <= n0*(c-a1) && c>=a1)
//			System.out.println(1);
//		else
//			System.out.println(0);
//	}
//}



/************* 19532. 수학은 비대면강의입니다 **************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main8 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		int y = (c*d - a*f) / (b*d - a*e);
		int x = (c*e - b*f) / (a*e - b*d);
		
		sb.append(x+" "+y);
		System.out.println(sb);
	}
}