// 2024.08.21
package SY.Aug;

/******** 2869. 달팽이는 올라가고 싶다 **********/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main4 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int A = Integer.parseInt(st.nextToken());
//		int B = Integer.parseInt(st.nextToken());
//		int V = Integer.parseInt(st.nextToken());
//		int day = (V-B)/(A-B);
//		
//		if((A-B)*day < (V-B))
//			day++;
//		
//		System.out.println(day);
//	}
//}


/************* 9506. 약수들의 합 ***************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main4 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		ArrayList <Integer> factor = new ArrayList<>();
//		
//		while(true) {
//			int n = Integer.parseInt(br.readLine());
//			if(n==-1) break;
//			int sum=0;
//			
//			for(int i=1; i<=n/2; i++) {
//				if(n%i==0) {
//					factor.add(i);
//					sum+=i;
//				}
//			}
//			if(sum==n) {
//				sb.append(n + " = " + factor.get(0));
//				for(int i=1; i<factor.size(); i++)
//					sb.append(" + " + factor.get(i));
//			}
//			else
//				sb.append(n + " is NOT perfect.");
//			sb.append("\n");
//			factor.clear();
//		}
//		System.out.println(sb);
//	}
//}




/************** 2581. 소수 **************/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main4 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum=0, min=0;
		
		for(int i=M; i<=N; i++) {
			Boolean prime = true;
			if(i==1) continue;
			
			for(int j=2; j<i/2+1; j++)
				if(i%j == 0) {
					prime = false;
					break;
				}
			if(prime) {
				sum+=i;
				if(min==0) min=i;
			}
		}
		if(sum==0)
			sb.append(-1);
		else
			sb.append(sum+"\n"+min);
		System.out.println(sb);
	}
}