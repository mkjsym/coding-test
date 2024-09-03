// 2024.08.27
package SY.Aug;

/********** 2839. 설탕배달 ************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main10 {
//	public static void main (String [] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int sugar [] = new int [N+1];
//		int bag [] = new int[] {3,5};
//		
//		sugar[0] = 0;
//		for(int i=1; i<=N; i++) {
//			sugar[i] = 5001;
//		}
//		
//		for(int i=0; i<bag.length; i++) {
//			for(int j=bag[i]; j<=N; j++) {
//				sugar[j] = Math.min(sugar[j], sugar[j-bag[i]]+1);
//			}
//		}
//		
//		if(sugar[N] > 5000)
//			System.out.println(-1);
//		else
//			System.out.println(sugar[N]);
//	}
//}



/******** 2750. 수 정렬하기 *********/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10 {
	public static void SelectSort(int k, int [] arr) {
		int min = 1001;
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
		int N = Integer.parseInt(br.readLine());
		int arr [] = new int[N];

		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		for(int i=0; i<arr.length; i++) {
			SelectSort(i,arr);
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb);
	}
}