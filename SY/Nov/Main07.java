// 2024.11.07
package SY.Nov;

/****** 11444. 피보나치 수 6 *******/
/*
 * 피보나치수 점화식을 행렬로 만들기-> {{1,1},{1,0}}^n하면 n번째 피보나치수 알 수 있음([0,1]) 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main07 {
	static long A[][] = {{1,1},{1,0}};
	static long mod = 1000000007;
	
	// 분할함수
	public static long[][] Divide(long b) {
		if(b==1) 
			return A;
		long matrix[][] = Divide(b/2);
		matrix = multiply(matrix, matrix);
		if(b%2 == 1) {
			matrix = multiply(matrix, A);
		}
		return matrix;
	}
	
	// 행렬곱 함수
	public static long[][] multiply(long[][] m1, long[][] m2) {
		long matrix[][] = new long[2][2];
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				for(int k=0; k<2; k++) {
					matrix[i][j] += m1[i][k] * m2[k][j];
					matrix[i][j] %= mod;
				}
			}
		}
		return matrix;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		long result = Divide(N)[0][1];
		System.out.println(result);
	}
}
