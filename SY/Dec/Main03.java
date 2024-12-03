// 2024.12.03
package SY.Dec;

/********* 1890. 점프 **********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main03 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N+1][N+1];
		long dp[][] = new long[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1] = 1;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int dist = arr[i][j];
				if(dist==0) break;
				
				if(i+dist<=N)	// 오른쪽으로 이동하는 경우
					dp[i+dist][j] += dp[i][j];
				if(j+dist<=N)	// 아랫쪽으로 이동하는 경우
					dp[i][j+dist] += dp[i][j];
			}
		}
		System.out.println(dp[N][N]);
	}
}
