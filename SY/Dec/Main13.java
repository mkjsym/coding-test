package SY.Dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/******* 1697. 숨바꼭질 *******/
public class Main13 {
	static Queue<Integer> que = new LinkedList<>();
	static int K;
	static int visited[] = new int[100001];
	
	static void BFS(int x) {
		que.offer(x);
		
		while(!que.isEmpty()){
			int current = que.poll();
			
			// 목적지 도달시 종료
			if(current==K)	
				return;
			
			// x-1, x+1, x*2 노드 각각에 +1씩
			if(current+1<100001 && visited[current+1]==0) {
				visited[current+1] = visited[current]+1;
				que.offer(current+1);
			}
			if(current-1>=0 && visited[current-1]==0) {
				visited[current-1] = visited[current]+1;
				que.offer(current-1);
			}
			if(current*2<100001 && visited[current*2]==0) {
				visited[current*2] = visited[current]+1;
				que.offer(current*2);
			}
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		BFS(N);
		System.out.println(visited[K]);
	}
}


/********* 7562. 나이트의 이동 **********/
//public class Main13 {
//	static int[][] graph;
//	static Queue<int[]> que = new LinkedList<>();
//	static int l, endX, endY;
//	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
//	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
//	
//	static void BFS(int x, int y) {
//		que.offer(new int[] {x,y});
//		if(x==endX && y==endY) 
//			return;
//		while(!que.isEmpty()) {
//			int [] current = que.poll();
//			int cX = current[0];
//			int cY = current[1];
//
//			for(int i=0; i<8; i++) {
//				int nx = cX + dx[i];
//				int ny = cY + dy[i];
//				if(nx<0 || nx>=l || ny<0 || ny>=l)
//					continue;
//				
//				if(graph[nx][ny]==0) {
//					graph[nx][ny] = graph[cX][cY] +1;
//					que.offer(new int[] {nx,ny});
//				}
//			}
//		}
//	}
//	
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int T = Integer.parseInt(br.readLine());
//		
//		for(int t=0; t<T; t++) {
//			l = Integer.parseInt(br.readLine());
//			graph = new int[l][l];
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			st = new StringTokenizer(br.readLine());
//			endX = Integer.parseInt(st.nextToken());
//			endY = Integer.parseInt(st.nextToken());
//			
//			BFS(x,y);
//			sb.append(graph[endX][endY]).append("\n");
//		}
//		System.out.println(sb);
//	}
//}