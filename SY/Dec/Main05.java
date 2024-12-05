package SY.Dec;

/******* 1965. 상자넣기 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main05 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		int dp[] = new int[n];
		int max = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j])
					dp[i] = Math.max(dp[i], dp[j]);
			}
			dp[i]++;
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}



//public class Main05 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//	
//		// dp방식
//		int dp[] = new int[N+1];
//		for(int i=2; i<=N; i++) {
//			dp[i] = dp[i-1] + 1;
//			if(i%K==0 && dp[i] > dp[i/K]+1) {
//				dp[i] = dp[i/K] + 1;
//			}
//		}
//		System.out.println(dp[N]);
//		
//		// 그리디 방식
//		int result = 0;
//		while(true) {
//			int target = (N/K) * K;
//			result += N-target;
//			N = target;
//			
//			if(N<K) break;
//			result++;
//			N /= K;
//		}
//		result += N-1;
//		System.out.println(result);
//	}
//}


// 4-1 상하좌우
//public class Main05 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int x=1, y=1;
//		
//		while(st.hasMoreTokens()) {
//			char ch = st.nextToken().charAt(0);
//			if(ch=='U' && x>1) 
//				x--;
//			else if(ch=='D' && x<N) 
//				x++;
//			else if(ch=='L' && y>1) 
//				y--;
//			else if(ch=='R' && y<N) 
//				y++;
//		}
//		System.out.println(x+" "+y);
//	}
//}



// 4-2 시각
//public class Main05 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		
//		int num1 = (60*60 - 45*45) * (N+1);	// 시에 3이 없을 때 경우의수
//		
//		int hour;	// 3이 들어가는 시의 개수
//		if(N==23) hour = 3;
//		else if(N>=13) hour = 2;
//		else if(N>=3)hour = 1;
//		else hour = 0;
//		
//		int num2 = 45*45*hour;	// 시에 3이 있고, 분초에 3이 없을 경우의수
//		
//		System.out.println(num1+num2);	// 시에 3이 없는 경우 + 있는 경우
//	}
//}