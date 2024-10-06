// 2024. 10.06
package SY.Oct;

/*********** 9461. 파도반 수열 ***********/
/*
 * int: 범위 초과됨. long타입으로 생성하기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main06 {
	static long[] dp = new long[101];
	public static long DP(int N) {
		// 이미 값이 있으면 그대로 리턴
		if(dp[N] != 0)
			return dp[N];
		dp[1]=dp[2]=1;
		for(int i=3; i<=N; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		return dp[N];
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(DP(N)).append("\n");
		}
		System.out.println(sb);
	}
}
