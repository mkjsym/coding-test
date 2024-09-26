package SY.Sep;

/********* 24060. 알고리즘수업 - 병합정렬 1 ********/
/*
 * 병합정렬 - 분할 후 합병정렬
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main26 {
	public static int [] sortedArr;
	public static int cnt = 0, K, result = -1;
	
	public static void Merge(int [] arr, int p, int q, int r) {
		int left = p;
		int right = q+1;
		int t = 0;
		
		while(left<=q && right<=r) {
			if(arr[left] <= arr[right]) 
				sortedArr[t++] = arr[left++];
			else 
				sortedArr[t++] = arr[right++];
		}
		
		while(left<=q) {
			sortedArr[t++] = arr[left++];	
		}
		while(right<=r) {
			sortedArr[t++] = arr[right++];
		}
		
		left = p;
		t = 0;
		while(left <= r) {
			cnt++;
			// K번째 저장되는 수 저장
			if(cnt == K) {
				result = sortedArr[t];
				break;
			}
			arr[left++] = sortedArr[t++];
		}	
	}
	
	public static void MergeSort(int [] arr, int p, int r) {
		if(p < r) {
			int q = (p + r) / 2;
			MergeSort(arr, p, q);
			MergeSort(arr, q+1, r);
			Merge(arr,p,q,r);
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[N];
		sortedArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		MergeSort(arr,0,N-1);
		System.out.println(result);
	}
}


	

