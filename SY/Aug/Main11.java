// 2024.08.28
package SY.Aug;

/**** 2587. 대표값2 ****/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main11 {
//	public static void SelectSort(int k, int [] arr) {
//		int min = 100;
//		int minIdx = 0;
//		int tmp;
//		for(int i=k; i<arr.length; i++) {
//			if(min>arr[i]) {
//				min = arr[i];
//				minIdx = i;
//			}
//		}
//		tmp = arr[minIdx];
//		arr[minIdx] = arr[k];
//		arr[k] = tmp;
//	}
//	
//	public static void main (String [] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int arr [] = new int[5];
//		int sum = 0;
//		
//		for(int i=0; i<5; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//			sum += arr[i];
//		}
//		for(int i=0; i<arr.length; i++)
//			SelectSort(i,arr);
//		sb.append(sum/5).append("\n");
//		sb.append(arr[2]);
//		System.out.println(sb);
//	}
//}



/***** 25305. 커트라인 *****/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11 {
	public static void SelectSort(int k, int [] arr) {
		int min = 10001;
		int minIdx = 0;
		int tmp;
		for(int i=k; i<arr.length; i++) {
			if(min>arr[i]) {
				min = arr[i];
				minIdx = i;
			}
		}
		tmp = arr[minIdx];
		arr[minIdx] = arr[k];
		arr[k] = tmp;
	}
	
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int arr [] = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++)
			SelectSort(i,arr);
		sb.append(arr[N-k]);
		System.out.println(sb);
	}
}