package SY.Dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/********* 1697. 숨바꼭질 **********/
public class Main12 {
	static int[][] graph;
	static Queue<int[]> que = new LinkedList<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N, M;
	
	static void BFS(int x, int y) {
		que.offer(new int[] {x,y});
		
		while(!que.isEmpty()) {
			int current[] = que.poll();		// 현재 노드 꺼내기
			int cX = current[0];	
			int cY = current[1];
			
			for(int i=0; i<4; i++) {
				int nX = cX + dx[i];	// 다음 노드(상/하/좌/우로 이동)
				int nY = cY + dy[i];
				
				if(nX<0 || nX>=N || nY<0 || nY>=M)
					continue;
				
				if(graph[nX][nY]==1) {	// 첫방문일 경우 이전노드+1값으로 갱신
					graph[nX][nY] = graph[cX][cY] + 1;
					que.offer(new int[] {nX, nY});
				}
			}
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				graph[i][j] = line.charAt(j)-'0';
			}
		}
		BFS(0,0);
		System.out.println(graph[N-1][M-1]);
	}
}