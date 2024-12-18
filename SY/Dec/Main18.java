package SY.Dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/****** 1026. 보물 *******/
public class Main18 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> A = new ArrayList<>();
		ArrayList<Integer> B = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(B,Collections.reverseOrder());
		Collections.sort(A);
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += B.get(i)*A.get(i);
		}
		System.out.println(sum);
	}
}
