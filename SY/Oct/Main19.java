package SY.Oct;

/********** 2156. 포도주 시식 **********/
/*
 * 계단오르기문제랑 유사한 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main19 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int dp[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = arr[0];	
		if(n>=2) dp[1] = arr[0] + arr[1];
		if(n>=3) dp[2] = Math.max(dp[1], Math.max(arr[0], arr[1])+arr[2]);
		
		for(int i=3; i<n; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3]+arr[i-1]) + arr[i]);
		}
		System.out.println(dp[n-1]);
	}
}
