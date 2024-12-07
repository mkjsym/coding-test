package SY.Dec;

/******** 11060. 점프점프 *********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main07 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dp[] = new int[N+1];
		int arr[] = new int[N+1];

		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1001;
		}
		
		dp[1] = 0;
		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=i+arr[i]; j++) {
				if(j>N) break;
				dp[j] = Math.min(dp[j], dp[i]+1);
			}
		}
		if(dp[N] == 1001)
			System.out.println(-1);
		else
			System.out.println(dp[N]);
	}
}