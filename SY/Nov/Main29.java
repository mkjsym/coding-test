// 2024.11.29
package SY.Nov;

/******* 1309. 동물원 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main29 {
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int mod = 9901;
		int dp[][] = new int[N+1][3];
		
		dp[1][0] = dp[1][1] = dp[1][2] = 1;
		
		for(int i=2; i<=N; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod;
		}
		int sum=0;
		for(int i: dp[N])
			sum += i;
		sum %= mod;
		System.out.println(sum);
	}
}
