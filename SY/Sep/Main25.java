// 2024.09.25
package SY.Sep;

/********* 27433. 팩토리얼2 ********/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main25 {
//	
//	public static long factorial(int N) {
//		if(N < 2) return 1;
//		return N*factorial(N-1);
//	}
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		System.out.println(factorial(N));
//	}
//}


/********** 10870. 피보나치 수 5 **********/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main25 {
//	
//	public static int Fibonacci(int n) {
//		if(n == 0) return 0;
//		if(n == 1) return 1;
//		return Fibonacci(n-1) + Fibonacci(n-2);
//	}
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		System.out.println(Fibonacci(n));
//	}
//}


/********** 25501. 재귀의 귀재 **********/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main25 {
	public static int cnt;
	public static int recursion(String s, int l, int r) {
		cnt++;
		if(l>=r) return 1;
		else if(s.charAt(l) != s.charAt(r)) return 0;
		else return recursion(s, l+1, r-1);
	}
	public static int isPalindrome(String s) {
		return recursion(s, 0, s.length()-1);
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			cnt = 0;
			String str = br.readLine();
			sb.append(isPalindrome(str)).append(" ")
			.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}