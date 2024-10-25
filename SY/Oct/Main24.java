// 2024.10.24
package SY.Oct;

/******** 11399. ATM *********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main24 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int sum = arr[0];
		for(int i=1; i<N; i++) {
			arr[i] = arr[i] + arr[i-1];
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
