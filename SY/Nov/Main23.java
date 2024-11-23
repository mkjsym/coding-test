// 2024.11.23
package SY.Nov;

/***** 11066. 파일 합치기 ******/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main23 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int K = Integer.parseInt(br.readLine());
			int arr[] = new int[K+1];
			int sum[] = new int[K+1];
			int dp[][] = new int[K+1][K+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + arr[i];	// 비용 누적합 
			}
			
			for(int i=1; i<=K; i++) {
				for(int from=1; from+i<=K; from++) { // from ~ to 묶음
					int to = from+i;
					dp[from][to] = Integer.MAX_VALUE;
					for(int mid=from; mid<to; mid++) {	// 나누는 지점. (from ~ mid), (mid+1 ~ to) 묶음
						dp[from][to] = Math.min(dp[from][to], 
								dp[from][mid] + dp[mid+1][to] + sum[to] - sum[from-1]);
					}
				}
			}
			sb.append(dp[1][K]).append("\n");
		}
		System.out.println(sb);
	}
}
