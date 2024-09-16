// 2024.09.16
package SY.Sep;

/******************* 24511. queuestack **********************/
/*
 * 큐, 스택의 원소를 모두 덱에 넣음: 시간초과.
 * => 스택은 의미없으므로 큐의 원소만 덱에 넣음.
 * 반복문으로 하나씩 추가-제거: 시간초과.
 * => 맨 앞에 삽입할 원소 추가, 맨 뒤 값만 pop하는 방식으로 
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main16 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] queuestack = new int[N];
		Deque <Integer> deque = new ArrayDeque<>();
		
		// 1. 자료구조 타입(큐or스택)을 배열에 저장
		for(int i=0; i<N; i++) {
			queuestack[i] = Integer.parseInt(st.nextToken());
		}
		
		// 2. 큐의 원소를 덱에 넣음
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(queuestack[i] == 0)
				deque.offer(num);
		}
		
		// 3. 삽입할 값을 맨앞에 추가, 맨 뒤 원소만 pop
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int x = Integer.parseInt(st.nextToken());
			deque.offerFirst(x);
			sb.append(deque.pollLast()).append(" ");
		}
		System.out.println(sb);
	}
}