// 2024.09.14
package SY.Sep;

/****** 2164. 카드 2 ******/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main14 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		Queue <Integer> queue = new LinkedList<>();
//		
//		for(int i=1; i<=N; i++) {
//			queue.offer(i);
//		}
//		
//		while(queue.size()>1) {
//			queue.poll();
//			queue.offer(queue.poll());
//		}
//		System.out.println(queue.poll());
//	}
//}


/******** 11866. 요세푸스 문제 0 *********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main14 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue <Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		sb.append("<");
		while(!queue.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll());
			if(!queue.isEmpty()) sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb);
	}
}