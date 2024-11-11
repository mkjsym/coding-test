// 2024.11.11
package SY.Nov;

/******* 2805. 나무 자르기 ******/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main11 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int tree[] = new int[N];
		int max = 0, min = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		while(min<=max) {
			// mid = 자를 길이
			int mid = (max+min)/2;
			long sum = 0;
			for(int i=0; i<N; i++) {
				// 가져갈 나무 길이 총합 계산
				if(tree[i]-mid > 0)
					sum += tree[i] - mid;
			}
			
			if(sum < M) {
				max = mid - 1;
			}
			else {
				min = mid + 1;
			}
		}
		System.out.println(max);
	}
}
