// 2024.11.04
package SY.Nov;

/******** 1780. 종이의 개수 *********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main04 {
	static int arr[][];
	static int minus = 0, zero = 0, one = 0;
	
	// 분할 함수
	public static void Divide(int r, int c, int size) {
		if(isSame(r,c,size)) {
			if(arr[r][c]==-1)
				minus++;
			else if(arr[r][c]==0)
				zero++;
			else
				one++;
			return;
		}
		
		size /= 3;
		Divide(r, c, size);				// [0,0]
		Divide(r, c+size, size);		// [0,1]
		Divide(r, c+size*2, size);		// [0,2]
		Divide(r+size, c, size);		// [1,0]
		Divide(r+size, c+size, size);	// [1,1]
		Divide(r+size, c+size*2, size);	// [1,2]
		Divide(r+size*2, c, size);		// [2,0]
		Divide(r+size*2, c+size, size);	// [2,1]
		Divide(r+size*2, c+size*2, size);	// [2,2]
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
		
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
	}
}
