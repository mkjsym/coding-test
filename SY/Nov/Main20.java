// 2024.11.20
package SY.Nov;

/******* 3986. 좋은단어 *******/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main20 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int t=0; t<N; t++) {
			String s = br.readLine();
			
			if(s.length() % 2 == 1) continue;
			
			Stack<Character> stack = new Stack<>();
			stack.push(s.charAt(0));
			for(int i=1; i<s.length(); i++) {
				if(!stack.isEmpty() && stack.peek() == s.charAt(i))
					stack.pop();
				else
					stack.push(s.charAt(i));
			}
			if(stack.isEmpty())
				cnt++;
		}
		System.out.println(cnt);
	}
}
