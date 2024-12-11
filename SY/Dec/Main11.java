// 2024.12.11
package SY.Dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*********** 2606. 바이러스 **********/
public class Main11 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int cnt = 0;
	static void DFS(int V) {
		visited[V] = true;
		
		for(int i: graph.get(V)) {
			if(!visited[i]) {
				cnt++;
				DFS(i);
			}
		}
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		DFS(1);
		System.out.println(cnt);
	}
}



/********** 2667. 단지번호붙이기 **********/
//public class Main11 {
//	static char[][] graph;
//	static int cnt = 0;
//	static int N;
//	
//	static boolean DFS(int x, int y) {
//		if(x<0 || x>=N || y<0 || y>=N)
//			return false;
//		
//		if(graph[x][y] == '1') {	// 방문하지 않았을 경우
//			graph[x][y] = '0';		// 방문상태로 변경
//			cnt++;					// 집 수 세기
//			DFS(x-1,y);				// 상하좌우 호출
//			DFS(x+1,y);
//			DFS(x,y-1);
//			DFS(x,y+1);
//			return true;
//		}
//		return false;
//	}
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		N = Integer.parseInt(br.readLine());
//		graph = new char[N][N];
//		ArrayList<Integer> cntArr = new ArrayList<>();
//		
//		for(int i=0; i<N; i++) {
//			String line = br.readLine();	
//			graph[i] = line.toCharArray();
//		}
//		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				if(DFS(i,j)) {
//					cntArr.add(cnt);	// 단지가 존재하면 집 수 add
//					cnt = 0;
//				}
//			}
//		}
//		Collections.sort(cntArr);
//		sb.append(cntArr.size()+"\n");
//		for(int i: cntArr) {
//			sb.append(i).append("\n");
//		}
//		System.out.println(sb);	
//	}
//}



/********* 1012. 유기농 배추 *********/
//public class Main11 {
//	static int graph[][];
//	static int M, N;
//	static boolean DFS(int x, int y) {
//		if(x<0 || x>=M || y<0 || y>=N)
//			return false;
//		
//		if(graph[x][y] == 1) {
//			graph[x][y] = 0;
//			DFS(x-1,y);
//			DFS(x+1,y);
//			DFS(x,y-1);
//			DFS(x,y+1);
//			return true;
//		}
//		return false;
//	}
//	
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int T = Integer.parseInt(br.readLine());
//		
//		for(int t=0; t<T; t++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			M = Integer.parseInt(st.nextToken());
//			N = Integer.parseInt(st.nextToken());
//			int K = Integer.parseInt(st.nextToken());
//			int cnt = 0;
//			graph = new int[M][N];
//			
//			for(int i=0; i<K; i++) {
//				st = new StringTokenizer(br.readLine());
//				int x = Integer.parseInt(st.nextToken());
//				int y = Integer.parseInt(st.nextToken());
//				graph[x][y] = 1;
//			}
//			for(int i=0; i<M; i++) {
//				for(int j=0; j<N; j++) {
//					if(DFS(i,j)) 
//						cnt++;
//				}
//			}
//			sb.append(cnt+"\n");
//		}
//		System.out.println(sb);
//	}
//}