// 2024.08.20
package SY;

/***************** 2563. 색종이 *******************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main3 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		Boolean board [][] = new Boolean [100][100];
//		int cnt = 0;
//		
//		for(int i=0; i<N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken())-1;
//			int y = Integer.parseInt(st.nextToken())-1;
//			for(int n=x; n<x+10; n++) {
//				for(int m=y; m<y+10; m++) {
//					if(board[n][m] == null) {
//						board[n][m] = true;
//						cnt++;
//					}
//				}
//			}
//		}
//		System.out.println(cnt);
//	}
//}



/**************** 2745. 진법변환 *****************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main3 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		String N = st.nextToken();
//		int B = Integer.parseInt(st.nextToken());
//		int num, dec = 0;
//		int n = N.length()-1;
//		for(char ch: N.toCharArray()) {
//			if('A'<=ch && ch<='Z')
//				num = ch - 55;
//			else
//				num = ch - '0';
//			dec += Math.pow(B, n) * num;
//			n--;
//		}
//		System.out.println(dec);
//	}
//}




/***************** 11005. 진법변환2 ******************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main3 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
//		
//		int N = Integer.parseInt(st.nextToken());
//		int B = Integer.parseInt(st.nextToken());
//		int rem = 0;
//		
//		while(N > 0) {
//			rem = N%B;
//			if(rem >= 10)
//				sb.append((char)(rem + 55));
//			else
//				sb.append(rem);
//			N/=B;
//		}
//		
//		System.out.println(sb.reverse());
//	}
//}




/************** 2292. 벌집 **************/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main3 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 1;
		int room=1;
		while(sum < n) {
			sum += 6*room;
			room++;
		}
		System.out.println(room);
	}
}