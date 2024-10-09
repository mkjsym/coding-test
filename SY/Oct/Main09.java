// 2024.10.09
package SY.Oct;

/********* 1932. 정수삼각형 **********/
/*
 * 삼각형 맨 아래부터 윗층으로 더해나가기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main09 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++)
				dp[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 두 수 비교해서 더 큰수를 윗층 숫자와 더함
		for(int i=n-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				dp[i-1][j] += Math.max(dp[i][j], dp[i][j+1]);
			}
		}
		
		System.out.println(dp[0][0]);
	}
}
