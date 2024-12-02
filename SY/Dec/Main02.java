// 2024.12.02
package SY.Dec;

/********* 11052. 카드 구매하기 **********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main02 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
			for(int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
			}
		}
		System.out.println(dp[N]);
	}
}
