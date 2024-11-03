// 2024.11.03
package SY.Nov;

/******** 1192.쿼드트리 *********/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main03 {
	static int arr[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void Divide(int r, int c, int size) {
		if(isSame(r,c,size)) {
			sb.append(arr[r][c]);
			return;
		}
		sb.append("(");
		
		size /= 2;
		Divide(r, c, size);				// 1사분면
		Divide(r, c+size, size);		// 2사분면
		Divide(r+size, c, size);		// 3사분면
		Divide(r+size, c+size, size);	// 4사분면
		
		sb.append(")");
	}
	
	// 같은색인지 판별하는 함수
	public static boolean isSame(int r, int c, int size) {
		int color = arr[r][c];
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(arr[i][j] != color)	// 첫번째 원소 기준 비교
					return false;
			}
		}
		return true;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = line.charAt(j)-'0';
			}
		}
		Divide(0,0,N);
		System.out.println(sb);
	}
}
