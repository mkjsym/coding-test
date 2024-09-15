// 2024.09.15
package SY.Sep;

/******* 28279. 덱2 ********/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main15 {	
//	static Deque <Integer> deque;
//	static StringBuilder sb;
//	
//	public static void DequeMethod(StringTokenizer st) {
//		int order = Integer.parseInt(st.nextToken());
//		if(order == 1) {
//			deque.offerFirst(Integer.parseInt(st.nextToken()));
//			return;
//		}
//		else if(order == 2) {
//			deque.offerLast(Integer.parseInt(st.nextToken()));
//			return;
//		}
//		else if(order == 3) {
//			sb.append(deque.isEmpty() ? -1 : deque.pollFirst());
//		}
//		else if(order == 4) {
//			sb.append(deque.isEmpty() ? -1 : deque.pollLast());
//		}
//		else if(order == 5) {
//			sb.append(deque.size());
//		}
//		else if(order == 6) {
//			sb.append(deque.isEmpty() ? 1 : 0);
//		}
//		else if(order == 7) {
//			sb.append(deque.isEmpty() ? -1 : deque.peekFirst());
//		}
//		else {
//			sb.append(deque.isEmpty() ? -1 : deque.peekLast());
//		}
//		sb.append("\n");
//	}
//	
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		sb = new StringBuilder();
//		deque = new LinkedList<>();
//		
//		for(int i=0; i<N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			DequeMethod(st);
//		}
//		System.out.println(sb);
//	}
//}


/******* 2346. 풍선 터뜨리기 *******/
/*
 * 덱을 LinkedList로 생성하면 메모리초과. ArrayDeque로 생성
 * ArrayDeque가 LinkedList보다 메모리 효율적, 연산속도 빠름.
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main15 {		
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. ArrayDeque로 덱 생성
		Deque <int[]> deque = new ArrayDeque<>();
		
		// 2. [종이 번호, 풍선 순서]를 덱에 넣음. 
		for(int i=1; i<=N; i++) {
			int [] balloon = new int[] {Integer.parseInt(st.nextToken()), i}; 
			deque.offer(balloon);
		}

		while(!deque.isEmpty()) {
			// 3. 맨 앞 풍선에 적힌 숫자 얻고 터뜨리기
			int balloon[] = deque.peekFirst();
			int num = balloon[0];
			sb.append(balloon[1]).append(" ");
			deque.pollFirst();
			
			if(deque.isEmpty()) break;
			
			// 4. 숫자가 양수이면 숫자만큼 맨 앞 풍선을 맨 뒤로 옮기기
			if(num > 0) {
				for(int i=0; i<num-1; i++) {
					deque.offerLast(deque.pollFirst());
				}
			}
			// 5. 음수이면 맨 뒤 풍선을 맨 앞으로 옮기기
			else {
				for(int i=num; i<0; i++) {
					deque.offerFirst(deque.pollLast());
				}
			}
		}
		System.out.println(sb);
	}
}
