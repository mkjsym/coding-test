package SY.Dec;

/******* 16194. 카드 구매하기 2 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main06 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dp[] = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
			for(int j=1; j<=i; j++) {
				dp[i] = Math.min(dp[i], dp[j]+dp[i-j]);
			}
		}
		System.out.println(dp[N]);
	}
}

//왕실의 나이트
//public class Main06 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine();
//		int x = str.charAt(0) - 96;
//		int y = str.charAt(1) - '0';
//		int cnt = 0;
//		int arr[][] = new int[][] {{-2,1}, {2,1}, {-2,-1}, {2,-1}, {1,2}, {-1,2}, {1,-2}, {-1,-2}};
//		
//		for(int i=0; i<8; i++) {
//			int tmpX = x + arr[i][0];
//			int tmpY = y + arr[i][1];
//			
//			if(tmpX >= 1 && tmpX <=8 && tmpY >= 1 && tmpY <= 8) {
//				cnt++;
//			}
//		}
//		System.out.println(cnt);
//	}
//}



