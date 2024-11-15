// 2024.11.15
package SY.Nov;

/******* 11286. 절댓값 힙 ********/
/*
 * 음수 큐, 양수 큐 분리
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main15 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> posQue = new PriorityQueue<>();
		PriorityQueue<Integer> negQue = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			// 값 넣기
			if(num > 0) posQue.add(num);
			else if(num < 0) negQue.add(Math.abs(num));
			
			// 값 빼기
			else {
				if(posQue.isEmpty() && negQue.isEmpty()) {
					sb.append(0);
				}
				else if(posQue.isEmpty()) {
					sb.append(negQue.poll()*(-1));
				}
				else if(negQue.isEmpty()) {
					sb.append(posQue.poll());
				}
				// 음수큐, 양수큐 모두 비어있지 않을 경우
				else {	
					int posNum = posQue.peek();
					int negNum = negQue.peek();
					if(posNum < negNum) 
						sb.append(posQue.poll());
					else if(posNum > negNum) 
						sb.append(negQue.poll()*(-1));
					else
						sb.append(negQue.poll()*(-1));	// 양수절댓값==음수절댓값이면 음수값 출력
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}

