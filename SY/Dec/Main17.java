package SY.Dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/****** 1715. 카드정렬하기 ******/ 
public class Main17 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			que.offer(Integer.parseInt(br.readLine()));
		}
		int sum = 0;
		while(que.size() > 1) {
			int x1 = que.poll();
			int x2 = que.poll();
			sum += x1+x2;
			que.offer(x1+x2);
		}
		System.out.println(sum);
	}
}
