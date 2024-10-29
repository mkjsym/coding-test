// 2024.10.28
package SY.Oct;

/******* 11054. 가장 긴 바이토닉 부분 수열 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main28 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dp1[] = new int[N];
		int dp2[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp1[i] = 1;
			dp2[i] = 1;
		}
		
		// 증가하는 수열
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j])
					dp1[i] = Math.max(dp1[i], dp1[j]+1);
			}
		}
		
		// 감소하는 수열
		for(int i=N-1; i>=0; i--) {
			for(int j=i; j<N; j++) {
				if(arr[i] > arr[j]) {
					dp2[i] = Math.max(dp2[i], dp2[j]+1);
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp1[i]+dp2[i]);
		}
		
		// 중복원소 빼기
		System.out.println(max-1);
	}
}
