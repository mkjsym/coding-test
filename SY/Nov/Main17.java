// 2024.11.17
package SY.Nov;

/******** 17298. 오큰수 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main17 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int [] arr = new int[N];
	
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			// 현재 원소가 스택의 top보다 크면 해당 인덱스 값을 현재 원소로. 
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		// 마지막에 스택에 남은 원소의 인덱스값을 -1로 초기화
		while(!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		for(int i=0; i<N; i++)
			sb.append(arr[i] + " ");
		System.out.println(sb);
	}
}
