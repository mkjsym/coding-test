// 2024.09.11
package SY.Sep;

/*********** 9012. 괄호 ***********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main11 {
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Stack <Character> stack = new Stack<>();
		
		for(int i=0; i<T; i++) {
			String ps = br.readLine();
			
			// 1. '(' 들어오면 push, ')' 들어오면 pop
			for(char c: ps.toCharArray()) {
				if(c=='(')
					stack.push(c);
				else {
					if(!stack.isEmpty())
						stack.pop();
					else {
						stack.push(c);
						break;
					}
				}
					
			}
			// 2. 스택에 남아있는 문자가 있으면 VPS 아님
			if(!stack.isEmpty()) sb.append("NO");
			else sb.append("YES");
			sb.append("\n");
			
			stack.clear();
		}
		System.out.println(sb);
	}
}
