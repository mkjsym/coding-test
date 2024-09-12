package SY.Sep;

/******* 4994. 균형잡힌세상 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main12 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack <Character> stack = new Stack<>();
		String str;
		
		while(!(str = br.readLine()).equals(".")) {
			for(char ch : str.toCharArray()) {
				if(ch=='(' || ch=='[') 
					stack.push(ch);
				else if(ch == ')') {
					if(stack.isEmpty() || stack.peek()!='(') {
						stack.push(ch);
						break;
					}
					stack.pop();
				}
				else if(ch == ']') {
					if(stack.isEmpty() || stack.peek()!='[') {
						stack.push(ch);
						break;
					}
					stack.pop();
				}	
			}
			
			if(stack.isEmpty()) sb.append("yes");
			else sb.append("no");
			sb.append("\n");
			
			stack.clear();
		}
		System.out.println(sb);
	}
}

