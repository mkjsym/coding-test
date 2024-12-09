package SY.Dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/******* 24479. 알고리즘수업 - 깊이 우선 탐색 1 ********/
/*
 * 2차원배열은 메모리초과. 리스트로 생성
 */
public class Main09 {
	static int visited[];
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int cnt = 1;
	
	static void DFS(int R) {
		visited[R] = cnt++;
		for(Integer i: graph.get(R)) {
			if(visited[i]==0)
				DFS(i);
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
		
		DFS(R);
		for(int i=1; i<=N; i++) {
			System.out.println(visited[i]);
		}
	}
}




/******* 24480. 알고리즘수업 - 깊이 우선 탐색 2 ********/
//public class Main09 {
//	static int visited[];
//	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//	static int cnt = 1;
//	
//	static void DFS(int R) {
//		visited[R] = cnt++;
//		for(Integer i: graph.get(R)) {
//			if(visited[i]==0)
//				DFS(i);
//		}
//	}
//	
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
//		// 내림차순 정렬
//		for(int i=0; i<=N; i++)
//			Collections.sort(graph.get(i), Collections.reverseOrder());	
//		
//		DFS(R);
//		for(int i=1; i<=N; i++) {
//			System.out.println(visited[i]);
//		}
//	}
//}