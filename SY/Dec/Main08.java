// 2024.12.08
package SY.Dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/******* 1260. DFS와 BFS *******/
public class Main08 {
	static int N;
	static boolean visit[];
	static int graph[][];
	static Queue<Integer> que = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	static void DFS(int v) {
		visit[v] = true;
		sb.append(v+" ");
		for(int i=1; i<=N; i++) {
			if(graph[v][i]==1 && !visit[i]) {
				DFS(i);
			}
		}
	}
	static void BFS(int v) {
		visit[v] = true;
		que.add(v);
		while(!que.isEmpty()) {
			v = que.poll();
			sb.append(v+" ");
			for(int i=1; i<=N; i++) {
				if(graph[v][i]==1 && !visit[i]) {
					que.add(i);
					visit[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		visit = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = graph[y][x] = 1;
		}

		DFS(V);
		sb.append("\n");
		visit = new boolean[N+1];
		BFS(V);
		System.out.println(sb);
	}
}


// 음료수 얼려 먹기
//public class Main08 {
//	static int N, M;
//	static char ice[][];
//	
//	static boolean DFS(int x, int y) {
//		if(x<0 || x>=N || y<0 || y>=M)
//			return false;
//		if(ice[x][y] == '0') {	// 아직 방문하지 않았을 경우
//			ice[x][y] = '1';
//			// 상하좌우 재귀호출
//			DFS(x-1,y);
//			DFS(x+1,y);
//			DFS(x,y-1);
//			DFS(x,y+1);
//			return true;
//		}
//		return false;
//	}
//	
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		ice = new char[N][M];
//		for(int i=0; i<N; i++) {
//			ice[i] = br.readLine().toCharArray();
//		}
//		int cnt=0;
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				if(DFS(i,j)) {
//					cnt++;
//				}
//			}
//		}
//		System.out.println(cnt);
//	}
//}
