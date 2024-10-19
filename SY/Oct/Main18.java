/// 2024.10.18
package SY.Oct;

/********** 10844. 쉬운 계단 수 **********/
/*
 * long 타입으로 선언. 연산할때마다 %mod해줘야 범위초과 안됨.
 * 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main18 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long mod = 1000000000;
		long arr[][] = new long[N+1][10];
		
		// 길이 1인 경우
		for(int i=1; i<=9; i++) {
			arr[1][i] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=9; j++) {
				// 0으로 시작하는 경우
				if(j==0) {
					arr[i][j] = arr[i-1][1] % mod;
				}
				// 9로 시작하는 경우
				else if(j==9) {
					arr[i][j] = arr[i-1][8] % mod;
				}
				else {
					arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1])% mod;
				}
			}
		}
		
		long result = 0;
		for(int i=0; i<=9; i++) {
			result += arr[N][i]; 
		}
		System.out.println(result % mod);
	}
}