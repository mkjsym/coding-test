// 2024.10.17
package SY.Oct;

/********** 10986. 나머지 합 ***********/
/*
 * (sum[i] - sum[i-1])%M = 0
 * 분배법칙 -> sum[i]%M - sum[i-1]%M = 0  -> sum[i]%M = sum[i-1]%M
 * => mod M 연산값이 같은 것들을 구하면 됨.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main17 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt[] = new int[M];
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			sum = (sum + Integer.parseInt(st.nextToken())) % M;
			// mod M 값이 같은 것의 수 세기
			cnt[sum]++;
		}
		
		// mod M = 0인 경우의 개수
		long result = cnt[0];
		
		// mod M 값이 같은 것 중 두개를 고르는 경우의수(nC2 조합) 더하기
		for(int i=0; i<M; i++) {
			result += (long)cnt[i]*(cnt[i]-1)/2;
		}
		System.out.println(result);
	}
}
