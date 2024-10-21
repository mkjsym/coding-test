// 2024.10.21
package SY.Oct;

/******* 12865. 평범한 배낭 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main21 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int stuff[][] = new int[N+1][2];	// [W,V]
		int dp[][] = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			stuff[i][0] = Integer.parseInt(st.nextToken());	// W
			stuff[i][1] = Integer.parseInt(st.nextToken());	// V
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {	
				if(j - stuff[i][0] >= 0)
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stuff[i][0]] + stuff[i][1]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		System.out.println(dp[N][K]);
	}
}
