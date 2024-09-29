// 2024.09.29
package SY.Sep;

/******** 15649. N과 M (1) *********/
/*
 * 1~N까지 중복제외 모든 수 탐색 -> DFS(깊이우선탐색)이용. dfs, bfs 공부하기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main29 {
	public static int N, M;
	public static int[] arr;	// 고른 숫자를 저장할 배열
	public static boolean[] visit;	// 노드 방문여부 저장할 배열
	public static StringBuilder sb = new StringBuilder();
	
	public static void DFS(int depth) {
		// M개만큼 골랐으면 출력
		if(depth == M) {
			for(int a: arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 방문하지 않은 노드일 경우
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;	// 방문상태로 변경
				arr[depth] = i+1;	// 고른 숫자 저장
				DFS(depth+1);		// 재귀호출(다음 숫자 고르기)
				visit[i] = false;	// 미방문상태로 변경
			}
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visit = new boolean[N];

		DFS(0);
		System.out.println(sb);	
	}
}
