// 2024.10.27
package SY.Oct;

/******** 2565. 전깃줄 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main27 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		int dp[] = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		// A전봇대 기준 정렬
		Arrays.sort(arr, (o1,o2)->{
			return o1[0] - o2[0];
		});
		
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i][1] > arr[j][1]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(N-max);
	}
}
