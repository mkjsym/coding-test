// 2024.09.27
package SY.Sep;

/****** 4779. 칸토어 집합 *******/
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main27 {
	public static char [] arr;
	public static void Cantor(int start, int len) {
		if(len == 1) return;
		
		// 가운데구간을 공백으로
		int divide = len / 3;
		for(int i=start+divide; i<start+(2*divide); i++) {
			arr[i] = ' ';
		}
		
		// 첫번째구간
		Cantor(start,divide);
		// 마지막구간
		Cantor(start+(2*divide),divide);
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String in;
		while((in = br.readLine()) != null) {
			int N = Integer.parseInt(in);
			int size = (int)Math.pow(3, N);
			arr = new char[size];
			for(int i=0; i<size; i++) {
				arr[i] = '-';
			}
			Cantor(0, size);
			for(char c: arr) 
				sb.append(c);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
