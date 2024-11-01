// 2024.11.01
package SY.Nov;

/****** 2740. 행렬곱셈 *******/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main01 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// A행렬
		int A[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// B행렬
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B[][] = new int[M][K];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<K; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 곱셈
		for(int n=0; n<N; n++) {
			for(int k=0; k<K; k++) {
				int sum=0;
				for(int m=0; m<M; m++) {
					sum += A[n][m] * B[m][k];
				}
				sb.append(sum).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
