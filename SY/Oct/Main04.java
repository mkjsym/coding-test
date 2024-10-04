// 2024.10.04
package SY.Oct;

/******** 24416. 알고리즘수업 - 피보나치수 1 *********/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main04 {
	static int cnt = 0;
	static int[] f;
	
	// 재귀
	public static int fib(int n) {
		if(n==1 || n==2) {	
			cnt++;
			return 1;	// 코드 1
		}
		else
			return fib(n-1)+fib(n-2);
	}
	
	// 동적계획법
	public static int fibonacci(int n) {
		f[0] = f[1] = 1;
		for(int i=2; i<n; i++) {
			f[i] = f[i-1] + f[i-2];	// 코드 2
			cnt++;
		}
		return f[n-1];
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		f = new int[n];
		
		fib(n);
		sb.append(cnt).append(" ");
		
		cnt=0;
		fibonacci(n);
		sb.append(cnt);
		
		System.out.println(sb);
	}
}

