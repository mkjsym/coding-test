package SY.Nov;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main16 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack <Character> stack = new Stack<>();
		String str = br.readLine();
		String bomb = br.readLine();
		int len = bomb.length();
		
		for(int i=0; i<str.length(); i++) {
			stack.push(str.charAt(i));
			if(stack.size() >= len) {
				boolean isBomb = true;
				for(int j=0; j<len; j++) {
					if(stack.get(stack.size() - len + j) != bomb.charAt(j)) {
						isBomb = false;
						break;
					}
				}
				if(isBomb) {
					for(int j=0; j<len; j++) {
						stack.pop();
					}
				}
			}
		}
		
		for(char c: stack) {
			sb.append(c);
		}
		System.out.println(stack.isEmpty() ? "FRULA" : sb);

	}
}
