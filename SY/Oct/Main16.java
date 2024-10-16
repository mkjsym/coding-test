// 2024.10.16
package SY.Oct;

/******** 11660. 구간합구하기5 *********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main16 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			// 블록단위로 누적합하고 교집합 빼주기
			for(int j=1; j<=N; j++) {
				arr[i][j] = arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// 구간 이외의 부분 빼주고, 중복해서 뺀 부분은 더해줌
			int result = arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1];
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
