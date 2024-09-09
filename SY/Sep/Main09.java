// 2024.09.09
package SY.Sep;

/******* 13241. 최고공배수 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main09 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		// 1. 작은 수를 small, 큰 수를 big으로 둠.
		long small = Math.min(A, B);
		long big = Math.max(A, B);
		
		// 2. 최대공약수(유클리드 호제법)
		while(small != 0) {
			long rem = big%small;
			big = small;
			small = rem;
		}
		long gcd = big;
		
		// 3. 최소공배수
		sb.append(A*B / gcd);
		
		System.out.println(sb);
	}
}
