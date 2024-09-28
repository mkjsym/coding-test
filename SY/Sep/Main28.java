// 2024.09.28
package SY.Sep;

/******* 1010. 다리놓기 ********/
/*
 * mCn 조합 
 * 분자, 분모 따로 계산 후 나누면 long타입 사용해도 범위초과 => 분자 곱셈과 분모 나눗셈을 한번에 하기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main28 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int bridge = 1;
			for(int i=1; i<=N; i++) {
				bridge = bridge * (M-i+1) / i;
			}
			sb.append(bridge).append("\n");
		}
		System.out.println(sb);
	}
}