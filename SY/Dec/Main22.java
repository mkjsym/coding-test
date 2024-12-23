// 2024.12.22
package SY.Dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/***** 1439. 문자열 뒤집기 *****/
//public class Main22 {
//	public static void main(String []args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String S = br.readLine();
//		int zero = 0;
//		int one = 0;
//		if(S.charAt(0) == '0') one++;
//		else zero++;
//			
//		for(int i=0; i<S.length()-1; i++) {
//			if(S.charAt(i) != S.charAt(i+1)) {
//				if(S.charAt(i)=='0') zero++;
//				else one++;
//			}
//		}
//		System.out.println(Math.min(zero, one));
//	}
//}

/***** 이코테 11-01. 모험가 길드 *****/
//public class Main22 {
//	public static void main(String []args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int arr[] = new int[N];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i=0; i<N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		Arrays.sort(arr);
//		// 1 2 2 2 3
//		int cnt = 0;
//		int result = 0;
//		for(int i=0; i<N; i++) {
//			cnt++;
//			if(cnt >= arr[i]) {
//				result++;
//				cnt = 0;
//			}
//		}
//		System.out.println(result);
//	}
//}


/**** 이코테 11-02. 곱하기 혹은 더하기 ****/
//public class Main22 {
//	public static void main(String []args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine();
//		int sum = 0;
//		for(int i=0; i<str.length(); i++) {
//			int n = str.charAt(i) - '0';
//			if(n<=1 || sum<=1)
//				sum += n;
//			else
//				sum *= n;
//		}
//		System.out.println(sum);
//	}
//}



/****** 이코테 11-04. 만들 수 없는 금액 ******/
//public class Main22 {
//	public static void main(String []args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int arr[] = new int[N];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i=0 ;i<N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		Arrays.sort(arr);
//		int target = 1;
//		for(int i=0; i<N; i++) {
//			if(target < arr[i]) break;
//			target += arr[i];
//		}
//		System.out.println(target);
//	}
//}