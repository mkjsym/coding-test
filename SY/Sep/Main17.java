// 2024.09.17
package SY.Sep;

/********* 4134. 다음 소수 **********/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main17 {
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			long n = Long.parseLong(br.readLine());
			if(n==0 || n==1) {
				sb.append(2).append("\n");
				continue;
			}
			while(true) {
				Boolean isPrime = true;		
				// 루트 n까지만 나눠서 소수 검사
				for(long j=2; j<=Math.sqrt(n); j++) {
					if(n%j==0) {
						isPrime = false;
						break;
					}
				}
				if(isPrime) break;
				n++;
			}
			sb.append(n).append("\n");
		}
		System.out.println(sb);
	}
}