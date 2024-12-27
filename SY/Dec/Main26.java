package SY.Dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// DFS 배열
//public class Main26 {
//	static int N;
//	static StringBuilder sb = new StringBuilder();
//	static boolean visited[];
//	static int graph[][];
//	public static void DFS(int V) {
//		visited[V] = true;
//		sb.append(V+" ");
//		for(int i=1; i<=N; i++) {
//			if(visited[i]==false && graph[V][i]==1) {
//				DFS(i);
//			}
//		}
//		
//	}
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int V = Integer.parseInt(st.nextToken());
//		graph = new int[N+1][N+1];
//		visited = new boolean[N+1];
//		for(int i=0; i<M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			graph[x][y] = graph[y][x] = 1;
//		}
//		DFS(V);
//		System.out.println(sb);
//	}
//}



// DFS ArrayList
//public class Main26 {
//	static int N;
//	static StringBuilder sb = new StringBuilder();
//	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//	static boolean[] visited;
//	public static void DFS(int V) {
//		visited[V] = true;
//		sb.append(V+" ");
//		for(Integer i: graph.get(V)) {
//			if(visited[i]==false) {
//				DFS(i);
//			}
//		}
//	}
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int V = Integer.parseInt(st.nextToken());
//		visited = new boolean[N+1];
//		for(int i=0; i<=N; i++) {
//			graph.add(new ArrayList<>());
//		}
//		
//		for(int i=0; i<M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			graph.get(x).add(y);
//			graph.get(y).add(x);
//		}
//		DFS(V);
//		System.out.println(sb);
//	}
//}


// BFS
//public class Main26 {
//	static int N;
//	static int graph[][];
//	static boolean visited[];
//	static Queue<Integer> que = new LinkedList<>();
//	static StringBuilder sb = new StringBuilder();
//	
//	public static void BFS(int V) {
//		visited[V] = true;
//		que.offer(V);
//		while(!que.isEmpty()) {
//			V = que.poll();
//			sb.append(V+" ");
//			for(int i=1; i<=N; i++) {
//				if(graph[V][i]==1 && !visited[i]) {
//					visited[i] = true;
//					que.offer(i);
//				}
//			}
//		}
//	}
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int V = Integer.parseInt(st.nextToken());
//		graph = new int[N+1][N+1];
//		visited = new boolean[N+1];
//		for(int i=0; i<M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			graph[x][y] = graph[y][x] = 1;
//		}
//			BFS(V);
//			System.out.println(sb);
//	}
//}


// BFS ArrayList
//public class Main26 {
//	static int N;
//	static boolean visited[];
//	static StringBuilder sb = new StringBuilder();
//	static Queue<Integer> que = new LinkedList<>();
//	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//	public static void BFS(int V) {
//		visited[V] = true;
//		que.offer(V);
//		while(!que.isEmpty()) {
//			V = que.poll();
//			sb.append(V+" ");
//			for(int i: graph.get(V)) {
//				if(!visited[i]) {
//					visited[i] = true;
//					que.offer(i);
//				}
//			}
//		}
//	}
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int V = Integer.parseInt(st.nextToken());
//		visited = new boolean[N+1];
//		for(int i=0; i<=N; i++) {
//			graph.add(new ArrayList<>());
//		}
//		for(int i=0; i<M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			graph.get(x).add(y);
//			graph.get(y).add(x);
//		}
//		BFS(V);
//		System.out.println(sb);
//	}
//}

//
//public class Main26 {
//	static int graph[][];
//	static int N, M;
//	static Queue<int []> que = new LinkedList<>();
//	static int cnt = 0;
//	static int[] dx = {-1,1,0,0};
//	static int[] dy = {0,0,-1,1};
//	
//	public static void BFS(int x, int y) {
//		que.offer(new int[] {x,y});
//		
//		while(!que.isEmpty()) {
//			int cur[] = que.poll();
//			int cx = cur[0];
//			int cy = cur[1];
//			for(int i=0; i<4; i++) {
//				int nx = cx + dx[i];
//				int ny = cy + dy[i];
//				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
//				if(graph[nx][ny]==1) {
//					graph[nx][ny] = graph[cx][cy]+1;
//					que.offer(new int[] {nx,ny});
//				}
//			}
//		}
//	}
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		graph = new int[N][M];
//		for(int i=0; i<N; i++) {
//			String line = br.readLine();
//			for(int j=0; j<M; j++) {
//				graph[i][j] = line.charAt(j)-'0';
//			}
//		}
//		BFS(0,0);
//		System.out.println(graph[N-1][M-1]);
//	}
//}


// x-1, x+1, 2*x
//public class Main26 {
//	static int visited[] = new int[100001];
//	static int K;
//	static Queue <Integer> que = new LinkedList<>();
//	public static void BFS(int N) {
//		que.offer(N);
//		while(!que.isEmpty()) {
//			int current = que.poll();
//			if(current == K) return;
//			
//			if(current-1>=0 && visited[current-1]==0) {
//				visited[current-1] = visited[current]+1;
//				que.offer(current-1);
//			}
//			if(current+1<100001 && visited[current+1]==0) {
//				visited[current+1] = visited[current]+1;
//				que.offer(current+1);
//			}
//			if(current*2<100001 && visited[current*2]==0) {
//				visited[current*2] = visited[current]+1;
//				que.offer(current*2);
//			}
//		}
//	}
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		K = Integer.parseInt(st.nextToken());
//		BFS(N);
//		System.out.println(visited[K]);
//	}
//}




//public class Main26 {
//	static int graph[][];
//	static int l, tx, ty;
//	static Queue <int []> que = new LinkedList<>();
//	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
//	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
//	public static void BFS(int x, int y) {
//		que.offer(new int[] {x,y});
//		while(!que.isEmpty()) {
//			int[] cur = que.poll();
//			int cx = cur[0];
//			int cy = cur[1];
//
//			for(int i=0; i<8; i++) {
//				int nx = cx + dx[i];
//				int ny = cy + dy[i];
//				if(nx<0 || nx>=l || ny<0 || ny>=l) continue;
//				if(graph[nx][ny]==0) {
//					graph[nx][ny] = graph[cx][cy]+1;
//					que.offer(new int[] {nx,ny});
//				}
//			}
//		}
//	}
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int T = Integer.parseInt(br.readLine());
//		for(int t=0; t<T; t++) {
//			l = Integer.parseInt(br.readLine());
//			graph = new int[l][l];
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			st = new StringTokenizer(br.readLine());
//			tx = Integer.parseInt(st.nextToken());
//			ty = Integer.parseInt(st.nextToken());
//			if(x!=tx || y!=ty)
//				BFS(x,y);
//			sb.append(graph[tx][ty]+"\n");
//		}
//		System.out.println(sb);
//	}
//}


public class Main26 {
	public static void main(String [] args) throws Exception {
		
	}
}