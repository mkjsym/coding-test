// 2024.10.20
package SY.Oct;

/*********** 11053. 가장 긴 증가하는 부분 수열 ***********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;;

public class Main20 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr [] = new int[n];
		int dp [] = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		int max = 1;
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				// arr[i]를 마지막값으로 하는 수열 중 가장 긴 길이를 dp에 저장
				if(arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
