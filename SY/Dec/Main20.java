package SY.Dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/****** 1946. 신입사원 *******/
public class Main20 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][2];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);	// 서류 기준 정렬
			
			int cnt = 1;
			int interview = arr[0][1];	// 서류 1등의 면접점수
			for(int i=1; i<N; i++) {
				if(arr[i][1] < interview) {
					cnt++;
					interview = arr[i][1];
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
}


/****** 2217. 로프 ******/
//public class Main20 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		ArrayList<Integer> arr = new ArrayList<>();
//		for(int i=0; i<N; i++) {
//			arr.add(Integer.parseInt(br.readLine()));
//		}
//		Collections.sort(arr,Collections.reverseOrder());
//		int weight = 0;
//		for(int i=0; i<N; i++) {
//			if(weight < arr.get(i)*(i+1))
//				weight = arr.get(i)*(i+1);
//		}
//		System.out.println(weight);
//	}
//}