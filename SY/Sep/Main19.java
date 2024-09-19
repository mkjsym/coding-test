// 2024.09.19
package SY.Sep;

/***** 10872. 팩토리얼 ******/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main19 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int factorial = (N==0) ? 1 : N;	// 0! = 1
//		for(int i=N-1; i>0; i--)
//			factorial *= i;
//		System.out.println(factorial);
//	}
//}


/******** 11050. 이항계수 1 *********/
/* 
 * 이항계수: 원하는 개수만큼 순서없이 뽑는 조합의 수
 * (n k) = nCk = n! / ((n-k)! * k!) 
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19 {
	public static int factorial(int N) {
		int factorial = (N==0) ? 1 : N;
		for(int i=N-1; i>0; i--)
			factorial *= i;
		return factorial;
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int nCk = factorial(N) / (factorial(N-K)*factorial(K));
		System.out.println(nCk);
	}
}