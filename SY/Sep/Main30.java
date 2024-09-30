// 2024.09.30
package SY.Sep;

/******** 15650. N과 M (2) *********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main30 {
	public static int N, M;
	public static int[] arr;
	public static boolean[] visit;
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
				// 오름차순일 경우만 숫자 저장
				if(depth!=0 && arr[depth-1] > i+1)
					continue;
				visit[i] = true;	
				arr[depth] = i+1;	
				DFS(depth+1);	
				visit[i] = false;	
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
