// 2024.09.08
package SY.Sep;

/************** 28278. 스택2 *************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main08 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		Stack <Integer> stack = new Stack<>();
//
//		for(int i=0; i<N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int order = Integer.parseInt(st.nextToken());
//			
//			if(order == 1) {
//				stack.push(Integer.parseInt(st.nextToken()));
//				continue;
//			}
//			else if(order == 2) {
//				sb.append(stack.isEmpty() ? -1 : stack.pop());
//			}
//			else if(order == 3) {
//				sb.append(stack.size());
//			}
//			else if(order == 4) {
//				sb.append(stack.isEmpty() ? 1 : 0);
//			}
//			else {
//				sb.append(stack.isEmpty() ? -1 : stack.peek());
//			}
//			sb.append("\n");
//		}
//		System.out.println(sb);
//	}
//}


/************* 10773. 제로 **************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main08 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack <Integer> stack = new Stack<>();

		// 1. 입력이 0이면 수를 지우고, 아니면 수를 적음
		for(int i=0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0)
				stack.push(num);
			else
				stack.pop();
		}
		
		// 2. 남아있는 모든 수의 합 출력
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}
