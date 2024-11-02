// 2024.11.02
package SY.Nov;

/******** 2630. 색종이 만들기 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main02 {
	static int arr[][];
	static int white = 0, blue = 0;
	
	// 분할 함수
	public static void Divide(int r, int c, int size) {
		if(isSame(r,c,size)) {	// 같은색종이면 개수++
			if(arr[r][c]==0)
				white++;
			else
				blue++;
			return;
		}
		
		size /= 2;
		Divide(r, c, size);				// 1사분면
		Divide(r, c+size, size);		// 2사분면
		Divide(r+size, c, size);		// 3사분
		Divide(r+size, c+size, size);	// 4사분면
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
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Divide(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
	}
}
