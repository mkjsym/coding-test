// 2024.10.12
package SY.Oct;

/****** 1463. 1로 만들기 *******/ 
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main12 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	
		int [] dp = new int [N+1];
		dp[0] = dp[1] = 0;
		for(int i=2; i<=N; i++) {
			// 1. x-1
			dp[i] = dp[i-1] +1;
			
			// 2. x/2
			if(i%2==0) 
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			
			// 3. x/3
			if(i%3==0) 
				dp[i] = Math.min(dp[i], dp[i/3]+1);			
		}
		System.out.println(dp[N]);
	}
}
