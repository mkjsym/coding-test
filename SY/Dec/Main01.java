/// 2024. 12.01
package SY.Dec;

/******** 9465. 스티커 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main01 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			int arr[][] = new int[2][n+1];
			int dp[][] = new int[2][n+1];
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1; j<=n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 첫번째열 초기화. 자기자신이 최댓값
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			
			// 현재 위치 이전에 발생한 경우의 수: 직전 대각선 or 전전 대각선
			for(int i=2; i<=n; i++) {
				dp[0][i] = arr[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
				dp[1][i] = arr[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
			}
			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
		}
		System.out.println(sb);
	}
}
