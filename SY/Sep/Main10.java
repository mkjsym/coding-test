// 2024.09.10
package SY.Sep;

/********** 1735. 분수 합 **********/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main10 {
//	public static int GCD(int s, int b) {
//		if(s>b) {
//			int tmp = s;
//			s = b;
//			b = tmp;
//		}
//		while(s!=0) {
//			int rem = b%s;
//			b = s;
//			s = rem;
//		}
//		return b;
//	}
//	
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
//		int ja1 = Integer.parseInt(st.nextToken());
//		int mo1 = Integer.parseInt(st.nextToken());
//		st = new StringTokenizer(br.readLine());
//		int ja2 = Integer.parseInt(st.nextToken());
//		int mo2 = Integer.parseInt(st.nextToken());
//		
//		// 1. 분자, 분모 계산
//		int num = ja1*mo2 + ja2*mo1;
//		int denum = mo1*mo2;
//		
//		// 2. 최대공약수 구하기
//		int gcd = GCD(num,denum);
//		
//		// 3. 분자, 분모 약분
//		num /= gcd;
//		denum /= gcd;
//		
//		sb.append(num).append(" ").append(denum);
//		System.out.println(sb);
//	}
//}



/*********** 2485. 가로수 ***********/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10 {
	public static int GCD(int s, int b) {
		if(s>b) {
			int tmp = s;
			s = b;
			b = tmp;
		}
		while(s!=0) {
			int rem = b%s;
			b = s;
			s = rem;
		}
		return b;
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] gap = new int[N-1];
		
		// 1. 가로수 간 간격 구하기
		int pre = Integer.parseInt(br.readLine());
		for(int i=0; i<N-1; i++) {
			int now = Integer.parseInt(br.readLine());
			gap[i] = now - pre;
			pre = now;
		}
		
		// 2. 모든 간격의 최대공약수
		int gcd = gap[0];
		for(int i=1; i<gap.length; i++) {
			gcd = GCD(gcd, gap[i]);
		}

		// 3. 간격 별로 들어갈 나무 수
		int sum = 0;
		for(int g : gap) {
			sum += (g / gcd) - 1;
		}
		System.out.println(sum);
	}
}