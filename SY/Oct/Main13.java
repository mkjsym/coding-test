// 2024.10.13
package SY.Oct;

/******* 11659. 구간 합 구하기 4 ********/
/*
 * 누적합: 배열의 각 인덱스에 누적합 저장
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main13 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N+1];
		
		// 배열에 누적합 저장
		st = new StringTokenizer(br.readLine());
		arr[1] = Integer.parseInt(st.nextToken());
		for(int n=2; n<=N; n++) {
			arr[n] = arr[n-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int n=0; n<M; n++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			// 중복되는 누적합 빼주기
			sb.append(arr[j] - arr[i-1]).append("\n");
		}
		System.out.println(sb);
	}
}
