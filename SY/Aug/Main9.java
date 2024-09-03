// 2024.08.26
package SY.Aug;

/************* 1018. 체스판 다시 칠하기 *************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//
//public class Main9 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		
//		int chess [][] = new int [N][M];
//		int cnt = 0;
//		int min = 65;
//		
//		for(int n=0; n<N; n++) {
//			String line = br.readLine();
//			for(int m=0; m<M; m++) 
//				chess[n][m] = line.charAt(m);
//		}
//		
//		for(int i=0; i<=N-8; i++) {
//			for(int j=0; j<=M-8; j++) {
//				
//				for(int n=0; n<8; n++) {
//					for(int m=0; m<8; m++) {
//						if((n%2==0 && m%2==0) || (n%2==1 && m%2==1)){
//							if(chess[n+i][m+j] != 'W')
//								cnt++;
//						}
//						else { 
//							if(chess[n+i][m+j] != 'B')
//								cnt++;
//						}
//					}
//				}
//				cnt = Math.min(cnt, 64-cnt);
//				min = Math.min(min, cnt);
//				cnt=0;
//			}
//		}
//
//		System.out.println(min);
//	}
//}


/************ 1436. 영화감독 숌 ************/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main9 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt=0;
		int num= 666;
		while(cnt<N) {
			if(String.valueOf(num).contains("666"))
				cnt++;
			num++;
		}

		System.out.println(num-1);
	}
}