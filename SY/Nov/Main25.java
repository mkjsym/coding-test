package SY.Nov;

/********** 2294. 동전2 **********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main25 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int dp[] = new int[k+1];
		int arr[] = new int[n+1];

		dp[0] = 0;
		for(int i=1; i<=k; i++) {
			dp[i] = 10001;
		}
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			for(int j=arr[i]; j<=k; j++) {
				dp[j] = Math.min(dp[j],dp[j-arr[i]]+1);
			}
		}
		if(dp[k]==10001) System.out.println(-1);
		else System.out.println(dp[k]);
	}
}
