package SY;

/****** 10989. 수 정렬하기 3 ******/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main13 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		int sorted [] = new int[10001];
//		
//		for(int i=0; i<N; i++) {
//			int n = Integer.parseInt(br.readLine()); 
//			sorted[n]++;
//		}
//		for(int i=0; i<sorted.length; i++) {
//			while(sorted[i] > 0) {
//				sb.append(i).append("\n");
//				sorted[i]--;
//			}
//		}
//		System.out.println(sb);
//	}
//}



/******* 1427. 소트인사이드 *******/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main13 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String N = br.readLine();
		int [] arr = new int[N.length()];
		
		for(int i=0; i<N.length(); i++) {
			arr[i] = N.charAt(i)-'0';
		}
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++)
			sb.append(arr[i]);
		System.out.println(sb.reverse());
	}
}