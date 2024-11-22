// 2024.11.22
package SY.Nov;

/******* 17299. 오등큰수 *******/
/*
 * 17298 오큰수를 등장횟수로 비교하는 문제
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main22 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int arr[] = new int[N];
		int cnt[] = new int[1000001];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			cnt[arr[i]]++;	// 숫자 등장 횟수 세기
		}
		for(int i=0; i<N; i++) { 
			while(!stack.isEmpty() && cnt[arr[stack.peek()]] < cnt[arr[i]]) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		for(int i=0; i<N; i++)
			sb.append(arr[i]+" ");
		System.out.println(sb);
	}
}
