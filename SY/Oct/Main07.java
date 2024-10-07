// 2024.10.07
package SY.Oct;

/*********** 1904. 01타일 ***********/
/*
 * 15746으로 나눈 나머지를 출력하는것. 문제 제대로 읽기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main07 {
	static int dp[];
	public static int DP(int N) {
		dp[0] = dp[1] = 1;
		
		for(int i=2; i<=N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 15746;
		}
		return dp[N];
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		int result = DP(N);
		System.out.println(result);
	}
}
