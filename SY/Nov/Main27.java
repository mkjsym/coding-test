// 2024.11.27
package SY.Nov;

/******* 2225. 합분해 *********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main27 {
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int dp[][] = new int[N+1][K+1];
		int mod = 1000000000;
		
		for(int i=1; i<=K; i++) {
			dp[0][i] = 1;	// 0을 만드는 경우 =1개
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
			}
		}
		System.out.println(dp[N][K]);
	}
}
