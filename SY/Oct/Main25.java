// 2024.10.25
package SY.Oct;

/********* 1541.잃어버린 괄호 *********/
/*
 * 1) 뺄셈기준으로 나누기 -> 2) 덧셈기준으로 나눠서 덧셈 먼저 계산. -> 3) 계산한 수를 모두 뺄셈(첫 수 제외)
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main25 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer subSt = new StringTokenizer(br.readLine(),"-");
		int sum=100000;
		
		while(subSt.hasMoreTokens()) {
			int n=0;
			StringTokenizer addSt = new StringTokenizer(subSt.nextToken(),"+");	
			while(addSt.hasMoreTokens()) {
				n += Integer.parseInt(addSt.nextToken());
			}
			if(sum==100000)
				sum = n;
			else
				sum -= n;
		}
		System.out.println(sum);
		
	}
}
