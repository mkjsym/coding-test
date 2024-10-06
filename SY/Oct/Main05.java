// 2024.10.05
package SY.Oct;

/********* 9184. 신나는 함수 실행 *********/
/*
 * 3차원 dp배열 이용해서 메모이제이션하기. 제공된 의사코드를 dp배열에 넣으면 됨.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main05 {
	static int[][][] dP = new int[21][21][21];
	
	public static int w(int a, int b, int c) {
		// 이미 값이 저장돼있으면 그 값 그대로 반환.
		if((0<=a&&a<21 && 0<=b&&b<21 && 0<=c&&c<21) && dP[a][b][c] != 0)
			return dP[a][b][c];
		
		if(a<=0 || b<=0 || c<=0)
			return 1;
		
		else if(a>20 || b>20 || c>20)
			return dP[20][20][20] = w(20,20,20);
		
		else if(a<b && b<c)
			return dP[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
		
		return dP[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}
	
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
				
			if(a==-1 && b==-1 && c==-1) break;
			int result = w(a,b,c);
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c)
			.append(") = ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
