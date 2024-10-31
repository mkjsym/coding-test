// 2024.10.30
package SY.Oct;

/********* 2447. 별찍기-10 ***********/
/*
 * N==1까지 분할해서 1개씩 별찍기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main30 {
	static char star[][];

	public static void stars(int N, int x, int y) {
		// N==1이면 더이상 분할하지 X
		if(N==1) {
			star[x][y] = '*';
			return;
		}
		N /= 3;
		
		// 가운데부분(1,1) 공백으로. 
		// stars() 재귀호출-> 더 작은 부분으로 분할하기
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i==1 && j==1) {
					continue;
				}
				stars(N, x+i*N, y+j*N);
			}
		}
		
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		star = new char[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				star[i][j] = ' ';
			}
		}
		stars(N,0,0);
		
		// 출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
