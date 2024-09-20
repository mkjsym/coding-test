// 2024.09.20
package SY.Sep;

/********** 4948. 베르트랑 공준 ***********/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main20 {
//	public static void main(String [] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int n;
//		while((n = Integer.parseInt(br.readLine())) != 0) {
//			int cnt = 0;
//			for(int i=n+1; i<=2*n; i++) {
//				if(i==1) continue;
//				Boolean isPrime = true;		
//				for(int j=2; j<=Math.sqrt(i); j++) {
//					if(i%j==0) {
//						isPrime = false;
//						break;
//					}
//				}
//				if(isPrime) cnt++;	
//			}
//			sb.append(cnt).append("\n");
//		}
//		System.out.println(sb);
//	}
//}