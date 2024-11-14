// 2024.11.13
package SY.Nov;

/******* 11279. 최대 힙 ********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main13 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		// PriorityQueue는 오름차순정렬. reverseOrder()로 내림차순 변경
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for(int i =0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				sb.append(queue.isEmpty() ? 0 : queue.poll()).append("\n");
			}
			else {
				queue.add(x);
			}
		}
		System.out.println(sb);
	}
}
