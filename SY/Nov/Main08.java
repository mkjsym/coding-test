// 2024.11.08
package SY.Nov;

/******** 11401. 이항계수 3 *********/
/*
 * 페르마의 소정리 -> a mod p의 역원 = a^(p-2) mod p
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main08 {
	static long mod = 1000000007;
	
	// 거듭제곱 분할함수. a는 밑, b는 지수
	public static long Divide(long a, long b) {
		if(b==1)
			return a%mod;
		
		long num = Divide(a, b/2);
		
		if(b%2==1) {
			return (num*num%mod) * a%mod;
		}
		else {
			return num*num%mod;
		}
	}
		
	public static long factorial(long n) {
		long num = 1;
		for(long i=2; i<=n; i++) {
			num = (num*i) % mod;
		}
		return num;
	}
	
		
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		// 분모 N!
		long num = factorial(N)%mod;
		
		// 분자 (K! * (N-1)!) % mod
		long denum = factorial(K)*factorial(N-K)%mod;
		
		// 분자의 역원
		long result = num * Divide(denum,mod-2) % mod;
		
		System.out.println(result);
	}
}
