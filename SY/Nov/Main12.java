// 2024.11.12
package SY.Nov;

/********* 2110. 공유기설치 *********/
/*
 * 설치 간격을 기준으로 탐색
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main12 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int home[] = new int[N];
		for(int i=0; i<N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);
		
		int min = 1;	
		int max = home[N-1];
		
		while(min <= max) {
			// mid = 최소 설치 간격
			int mid = (min+max) / 2;
			
			// 첫번째집에 설치
			int loc = home[0];	
			int cnt = 1;		
			
			// mid만큼의 간격으로 공유기설치
			for(int i=1; i<N; i++) {
				if(home[i] - loc >= mid) {	
					loc = home[i];
					cnt++;
				}
			}
			
			// 설치된 수가 설치해야하는 수보다 적으면 간격 줄이기
			if(cnt < C) {
				max = mid -1;
			}
			// 많으면 간격 늘리기
			else {
				min = mid +1;
			}
		}
		System.out.println(max);
	}
}
