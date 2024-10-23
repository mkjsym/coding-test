// 2024.10.23
package SY.Oct;

/******* 1931.회의실 배정 ********/
/*
 * 종료시간이 빠를수록 더 많은 회의를 할 수 있음.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main23 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		// 종료시간 빠른 순 정렬. 종료시간 같으면 시작시간 빠른순
		Arrays.sort(arr, (o1, o2)->{
			if(o1[1] == o2[1])
				return o1[0]-o2[0];
			else
				return o1[1]-o2[1];
		});
		
		int cnt = 1;
		int end = arr[0][1];
		// 시작시간 >= 이전회의 종료시간인 경우만 count
		for(int i=1; i<N; i++) {
			if(arr[i][0] >= end) {
				end = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
