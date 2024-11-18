// 02024.11.18
package SY.Nov;

/********* 10828. 스택 ***********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main18 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if(st.hasMoreTokens()) {
				stack.push(Integer.parseInt(st.nextToken()));
				continue;
			}
			else if(order.equals("pop")) {
				sb.append(stack.isEmpty() ? -1 : stack.pop());
			}
			else if(order.equals("size")) {
				sb.append(stack.size());
			}
			else if(order.equals("empty")) {
				sb.append(stack.isEmpty() ? 1 : 0);
			}
			else {
				sb.append(stack.isEmpty() ? -1 : stack.peek());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
