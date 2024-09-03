// 2024.08.29
package SY.Aug;

/******* 2751. 수 정렬하기 2 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main12 {
	public static int [] sortedArr;

	public static void Merge(int [] arr, int start, int middle, int end) {
		int left = start;
		int right = middle+1;
		int now = start;
		
		while(left<=middle && right<=end) {
			if(arr[left] > arr[right]) 
				sortedArr[now++] = arr[right++];

			else 
				sortedArr[now++] = arr[left++];

		}
		
		if(left>middle) {
			while(right<=end)
				sortedArr[now++] = arr[right++];
		}
		else {
			while(left<=middle)
				sortedArr[now++] = arr[left++];
		}
		
		for(int i=start; i<=end; i++)
			arr[i] = sortedArr[i];
	}
	
	public static void MergeSort(int [] arr, int start, int end) {
		if(start < end) {
			int middle = (start + end) / 2;
			MergeSort(arr, start, middle);
			MergeSort(arr, middle+1, end);
			Merge(arr,start,middle,end);
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		sortedArr = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		MergeSort(arr,0,N-1);
		
		for(int i=0; i<N; i++)
			sb.append(arr[i]).append("\n");
		System.out.println(sb);
	}
}
