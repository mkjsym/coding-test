// 2024.11.14
package SY.Nov;

/******* 1927. 최소 힙 *******/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main14 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
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
