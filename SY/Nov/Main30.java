// 2024.11.30
package SY.Nov;

/********* 11048. 이동하기 **********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main30 {
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N+1][M+1];
		int dp[][] = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = arr[i][j] + Math.max(Math.max(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
			}
		}
		System.out.println(dp[N][M]);
	}
}
