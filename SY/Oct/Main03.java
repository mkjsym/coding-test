// 2024.10.03
package SY.Oct;

/******** 14888. 연산자 끼워넣기 **********/
/*
 * 숫자 개수를 depth로 해서 DFS함수 작성. 모든 경우의 수를 탐색함
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main03 {
	static int K = 0;
	static int[] arr;
	static int[] op = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void DFS(int num, int depth) {
		// 숫자 개수만큼 탐색했으면 max,min 저장후 종료
		if(depth == arr.length) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		for(int i=0; i<4; i++) {
			// 연산자 개수 감소시키고(--) 재귀호출 종료시 복구(++)
			if(op[i]>0) {
				op[i]--;
				switch(i) {
					case 0: DFS(num + arr[depth], depth+1); break;
					case 1: DFS(num - arr[depth], depth+1); break;
					case 2: DFS(num * arr[depth], depth+1); break;
					case 3: DFS(num / arr[depth], depth+1); break;
				}
				op[i]++;
			}
		}
	}
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		// 수열 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		// 연산자 개수 저장
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(arr[0],1);
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}
}
