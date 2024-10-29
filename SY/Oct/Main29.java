// 2024.10.29
package SY.Oct;

/******* 9251. LCS ********/
/*
 * 표에 표시하면서 규칙찾기. 문자가 같으면 왼쪽 위 대각선 값+1, 다르면 max(왼쪽,윗쪽)
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main29 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int len1 = s1.length();
		int len2 = s2.length();
		int dp[][] = new int[len1+1][len2+1];
	
		for(int i=1; i<=len1; i++) {
			for(int j=1; j<=len2; j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[len1][len2]);
	}
}
