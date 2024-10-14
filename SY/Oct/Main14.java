// 2024.10.14
package SY.Oct;

/********** 2559. 수열 **********/
/*
 * 슬라이딩 윈도우처럼 오른쪽 수 더하고 왼쪽 수 빼기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main14 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		
		// 수열 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// k개만큼의 누적합 저장
		int max = 0;
		for(int i=0; i<K; i++) {
			max += arr[i];
		}
		
		// (누적합 + 오른쪽 수 - 맨 왼쪽 수) 계산후 max값 구하기
		int sum = max;
		for(int i=0; i<N-K; i++) {
			sum += arr[i+K] - arr[i];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
