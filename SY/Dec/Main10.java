// 2024.12.10
package SY.Dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*********** 24445. 알고리즘수업 - 너비 우선 탐색 1 ************/
public class Main10 {
	static int[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static Queue<Integer> que = new LinkedList<>();
	static int cnt = 1;
	
	static void BFS(int R) {
		visited[R] = cnt++;
		que.offer(R);
		while(!que.isEmpty()) {
			int current = que.poll();
			for(Integer i: graph.get(current)) {
				if(visited[i]==0) {
					visited[i] = cnt++;
					que.offer(i);
				}
			}
		}
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		visited = new int[N+1];
		
		for(int i=0; i<=N; i++)
			graph.add(new ArrayList<>());

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		for(int i=0; i<=N; i++)
			Collections.sort(graph.get(i));	
		
		BFS(R);
		for(int i=1; i<=N; i++) {
			System.out.println(visited[i]);
		}
	}
}

/*********** 24445. 알고리즘수업 - 너비 우선 탐색 2 ************/
//public class Main10 {
//	static int[] visited;
//	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//	static Queue<Integer> que = new LinkedList<>();
//	static int cnt = 1;
//	
//	static void BFS(int R) {
//		visited[R] = cnt++;
//		que.offer(R);
//		while(!que.isEmpty()) {
//			int current = que.poll();
//			for(Integer i: graph.get(current)) {
//				if(visited[i]==0) {
//					visited[i] = cnt++;
//					que.offer(i);
//				}
//			}
//		}
//	}
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int R = Integer.parseInt(st.nextToken());
//		visited = new int[N+1];
//		
//		for(int i=0; i<=N; i++)
//			graph.add(new ArrayList<>());
//
//		for(int i=0; i<M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			graph.get(x).add(y);
//			graph.get(y).add(x);
//		}
//		
//		for(int i=0; i<=N; i++)
//			Collections.sort(graph.get(i), Collections.reverseOrder());	
//		
//		BFS(R);
//		for(int i=1; i<=N; i++) {
//			System.out.println(visited[i]);
//		}
//	}
//}