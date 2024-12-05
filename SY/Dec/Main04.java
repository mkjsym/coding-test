// 2024.12.04
package SY.Dec;

/******** 12852. 1로 만들기 2 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main04 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1];
		int arr[] = new int[N+1];	// 인덱스 저장용 배열
		
		for(int i=2; i<=N; i++) {
			// 1빼기
			dp[i] = dp[i-1] + 1;
			arr[i] = i-1;
			
			// 3으로 나누기
			if(i%3==0 && dp[i]>dp[i/3]+1) {
				dp[i] = dp[i/3] + 1;
				arr[i] = i/3; 
			}
			// 2로 나누기
			if(i%2==0 && dp[i]>dp[i/2]+1) {
				dp[i] = dp[i/2] + 1;
				arr[i] = i/2; 
			}
		}
		
		sb.append(dp[N]).append("\n");
		int idx = N;
		for(int i=0; i<=dp[N]; i++) {
			sb.append(idx).append(" ");
			idx = arr[idx];
		}
		System.out.println(sb);
	}
}



/****** 큰수의법칙 *******/
//public class Main04 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		int arr[] = new int[N];
//		
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		Arrays.sort(arr);		
//		
//		int big = arr[N-1];
//		int secondBig = arr[N-2];
//		int bigCnt = M/K;	// 가장 큰 수 더하는 횟수
//		int secondCnt = M%K;	// 두번째수 더하는 횟수
//		int sum = big*bigCnt*K + secondBig*secondCnt;
//		System.out.println(sum);
//		
//	}
//}



/****** 숫자카드게임 *******/
//public class Main04 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int arr[][] = new int[N][M];
//		
//		int max = 0;
//		for(int i=0; i<N; i++) {
//			st = new StringTokenizer(br.readLine());
//			int min = 10000;
//			for(int j=0; j<M; j++) {
//				arr[i][j] = Integer.parseInt(st.nextToken());
//				min = Math.min(min, arr[i][j]);
//			}
//			max = Math.max(max, min);
//		}
//		System.out.println(max);
//	}
//}