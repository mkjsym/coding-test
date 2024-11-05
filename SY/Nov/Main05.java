// 2024.11.05
package SY.Nov;

/****** 1629. 곱셈 *******/
/*
 * (A*B)mod C = (A mod C * B mod C)modC 성질 이용
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main05 {
	static long A, C;
	public static long Divide(long b) {
		if(b==1)	// 지수가 1이 될 때까지 분할
			return A%C;
		
		long divNum = Divide(b/2);
		if(b%2 == 1) // 지수가 홀수일 때: 같은 지수로 맞춰주고 한번 더 곱하기
			return (divNum*divNum % C) * A%C;
		else
			return divNum*divNum % C;
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(Divide(B));
	}
}
