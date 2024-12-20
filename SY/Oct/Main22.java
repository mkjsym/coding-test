// 2024.10.22
package SY.Oct;

/******* 11047. 동전 0 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main22 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [] arr = new int[N];
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=N-1; i>=0; i--) {
			if(arr[i]<=K) {
				cnt += (K / arr[i]);
				K %= arr[i];
			}
		}
		System.out.println(cnt);
	}
}
