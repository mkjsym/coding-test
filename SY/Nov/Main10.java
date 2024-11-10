// 2024.11.10
package SY.Nov;

/******* 1654. 랜선자르기 *******/
/*
 * 이진탐색 기준을 랜선의 길이로.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main10 {		
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[K];
		long max = 0, min = 1;
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}

		while(min <= max) {
			// mid = 자를 길이
			long mid = (min + max) / 2;
			long cnt = 0;
			
			// mid 길이로 만들 수 있는 랜선 개수 count
			for(int i=0; i<arr.length; i++) {
				cnt += (arr[i]/mid);
			}
			
			// 랜선 개수가 구하려는 개수보다 작으면 최대길이 줄이기
			if(cnt < N) {
				max = mid-1;
			}
			// 랜선 개수가 구하려는 개수보다 많으면 최소길이 키우기
			else {
				min = mid + 1;
			}
		}
		System.out.println(max);
	}
}
