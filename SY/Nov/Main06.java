// 2024.11.06
package SY.Nov;

/****** 10830. 행렬제곱 *******/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main06 {
	static int A[][];
	static int N;
	static int mod = 1000;
	
	// 분할함수
	public static int[][] Divide(long b) {
		if(b==1) 
			return A;
		int matrix[][] = Divide(b/2);
		matrix = multiply(matrix, matrix);
		if(b%2 == 1) {
			matrix = multiply(matrix, A);
		}
		return matrix;
	}
	
	// 행렬곱 함수
	public static int[][] multiply(int[][] m1, int[][] m2) {
		int matrix[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					matrix[i][j] += m1[i][k] * m2[k][j];
					matrix[i][j] %= mod;
				}
			}
		}
		return matrix;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		A = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken()) % mod;
			}
		}
		
		int result[][] = Divide(B);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
