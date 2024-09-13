// 2024.09.13
package SY.Sep;

/********* 12789. 도키도키 간식드리미 *********/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main13 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int lastNum = 0;
//		Boolean isNice = true;
//		
//		// 1. 1열짜리 공간을 stack으로 
//		Stack <Integer> stack = new Stack<>();
//		
//		for(int i=0; i<N; i++) {
//			int num = Integer.parseInt(st.nextToken());
//			
//			// 2. (대기열의 번호) < (stack의 top)일 경우에만 스택에 push. => 스택 오름차순 정렬   
//			if(stack.isEmpty() || stack.peek()>num) {
//				stack.push(num);
//			}
//			
//			// 3. 대기열의 번호가 더 크면 작아질때까지 pop. (pop되는 번호) < (가장 최근에 나간 번호) 이면 간식받기 실패 
//			while(!stack.isEmpty() && stack.peek()<num) {
//				if(stack.peek() < lastNum) {
//					isNice = false;
//					break;
//				}
//				lastNum = stack.peek();
//				stack.pop();
//			}
//			
//		}
//
//		// 4. 스택이 빌 때까지 반복해서 pop하기
//		while(!stack.isEmpty()) {
//			if(stack.peek() < lastNum) {
//				isNice = false;
//				break;
//			}
//			lastNum = stack.peek();
//			stack.pop();
//		}
//		
//		if(isNice) System.out.println("Nice");
//		else System.out.println("Sad");
//	}
//}



/******** 18258. 큐2 *********/
/*
 * 큐는 LinkedList로 생성
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main13 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue <Integer> queue = new LinkedList<>();
		int rear=0;
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if(order.equals("push")) {
				int X = Integer.parseInt(st.nextToken());
				queue.offer(X);
				rear = X;
				continue;
			}
			else if(order.equals("pop")) {
				sb.append(queue.isEmpty() ? -1 : queue.poll());
			}
			else if(order.equals("size")) {
				sb.append(queue.size());
			}
			else if(order.equals("empty")) {
				sb.append(queue.isEmpty() ? 1 : 0);
			}
			else if(order.equals("front")) {
				sb.append(queue.isEmpty() ? -1 : queue.peek());
			}
			else {
				sb.append(queue.isEmpty() ? -1 : rear);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}