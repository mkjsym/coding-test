// 2024.09.21
package SY.Sep;

/******* 17103. 골드바흐 파티션 *******/
/*
 * 에라토스테네스의 체 이용. (기존의 루트n까지 나눠서 찾는 방법은 시간초과)
 * 에라토스테네스의 체: 소수들의 배수를 지우는 방식으로 소수를 찾는 방법
 */
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main21 {
//	public static void main(String [] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int T = Integer.parseInt(br.readLine());
//		int len = 1000000;
//		
//		// 1. 모든 수에 대하여 소수 판별(에라토스테네스의 체)
//		Boolean isPrime [] = new Boolean[len+1] ;
//		isPrime[0] = isPrime[1] = false;
//		for(int i=2; i<isPrime.length; i++) {
//			isPrime[i] = true;
//		}
//		
//		for(int i=2; i<=Math.sqrt(len); i++) {
//			if(isPrime[i]) {
//				for(int j=i*i; j<=len; j+=i)
//					isPrime[j] = false;
//			}
//		}
//		
//		// 2. 골드바흐 파티션 개수 세기
//		for(int t=0; t<T; t++) {
//			int N = Integer.parseInt(br.readLine());
//			int cnt = 0;
//			for(int i=2; i<=N/2; i++) {
//				if(isPrime[i]&&isPrime[N-i])
//					cnt++;
//			}
//			sb.append(cnt).append("\n");
//		}
//		System.out.println(sb);
//	}
//}


/********* 13909. 창문닫기 **********/
/*
 * 약수의 개수가 홀수인 창문만 열려있음. 제곱수는 약수의 개수가 홀수.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main21 {
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		for(int i=1; i*i<=N; i++) {
			cnt++;
		}
		System.out.println(cnt);
	}
}
