// 2024.11.09
package SY.Nov;

/******* 1920. 수 찾기 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main09 {
	public static int BinarySearch(int [] A, int num) {
		int start = 0;
		int last = A.length - 1;
		
		while(start <= last) {
			int mid = (start + last)/2;
			
			// num이 중간위치보다 작을 경우
			if(num < A[mid]) {
				last = mid - 1;
			}
			// num이 중간위치보다 클 경우
			else if(num > A[mid]) {
				start = mid + 1;
			}
			// num이 중간위치와 같을 경우
			else {
				return 1;
			}
		}
		return 0;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		// 정렬
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(BinarySearch(A,num)).append("\n");
		}
		System.out.print(sb);
	}
}
