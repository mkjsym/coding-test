// 2024.11.28
package SY.Nov;

/******* 11057. 오르막수 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main28 {
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N+1][10];
		int mod = 10007;
		
		// 길이가 1인 경우는 오르막수 1개씩 존재
		for(int i=0; i<=9; i++)
			dp[1][i] = 1;
		
		for(int i=2; i<N+1; i++) {
			for(int j=0; j<=9; j++) {
				// 끝 수가 j보다 작은 모든 수 더하기
				for(int k=0; k<=j; k++) {
					dp[i][j] = (dp[i][j] + dp[i-1][k]) % mod;
				}
			}
		}
		
		int sum = 0;
		for(int i: dp[N]) {
			sum += i;
		}
		System.out.println(sum % mod);
	}
}
