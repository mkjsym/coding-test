// 2024.10.08
package SY.Oct;

/******** 1912. 연속합 **********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main08 {
	static int [] arr;
	static int [] dp;
	
	public static int DP(int n) {
		dp[0] = arr[0];
		int max = dp[0];
		
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
			max = Math.max(dp[i], max);
		}
		return max;
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		dp = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int result = DP(n);
		System.out.println(result);
	}
}
