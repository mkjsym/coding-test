// 2024.10.31
package SY.Oct;

/******** 11729. 하노이 탑 이동순서 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main31 {
	static StringBuilder sb = new StringBuilder();
	static int K=0;
	public static void hanoi(int N, int start, int mid, int end) {
		K++;
		// 원판이 하나남은 경우 바로 start->end로 이동
		if(N==1) {
			sb.append(start + " " + end).append("\n");
			return;
		}
				
		hanoi(N-1,start,end,mid);	// 원판들을 mid로 이동
		sb.append(start + " " + end).append("\n");
		hanoi(N-1,mid,start,end);	// 원판들을 mid->end로 이동
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hanoi(N,1,2,3);
		System.out.println(K);
		System.out.println(sb);
	}
}
