// 2024.10.11
package SY.Oct;

/******** 1149. RGB거리 *********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main11 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			if(i==0) continue;
			// r,g,b 각각을 선택하는 경우 + 이전 집의 최솟값
			arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);	// r
			arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);	// g
			arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]);	// b
		}
		
		int result = Math.min(Math.min(arr[N-1][0],arr[N-1][1]),arr[N-1][2]);
		System.out.println(result);
	}
}
