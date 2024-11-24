package SY.Nov;

/********** 2293. 동전1 **********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main24 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int dp[] = new int[k+1];	// 가치를 만들 수 있는 경우의 수 dp 배열
		int arr[] = new int[n+1];
		dp[0] = 1;
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			for(int j=arr[i]; j<=k; j++) {
				dp[j] += dp[j-arr[i]];
			}
		}
		System.out.println(dp[k]);
	}
}