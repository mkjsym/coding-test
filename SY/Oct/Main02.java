// 2024.10.02
package SY.Oct;

/******** 15652. N과 M (4) *********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main02 {
	public static int N, M;
	public static int[] arr;
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
		
		for(int i=0; i<N; i++) {
			if(depth!=0 && arr[depth-1]>i+1)
				continue;
			arr[depth] = i+1;	
			DFS(depth+1);	
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		DFS(0);
		System.out.println(sb);	
	}
}
