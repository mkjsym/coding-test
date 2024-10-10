// 2024.10.10
package SY.Oct;

/********** 2579. 계단오르기 **********/
/*
 * 계단오르는 방식은 아래 두가지경우 뿐
 * 1. (n-2) -> n 
 * 2. (n-3) -> (n-1) -> n 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int dp[] = new int[n];
		
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		dp[0] = arr[0];
		if(n>=2) dp[1] = arr[0] + arr[1];
		if(n>=3) dp[2] = Math.max(arr[0], arr[1]) + arr[2];

		for(int i=3; i<n; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+arr[i-1]) + arr[i];
		}
		System.out.println(dp[n-1]);
	}
}
