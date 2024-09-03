// 2024.09.03
package SY.Sep;

/**************** 18870. 좌표압축 ****************/
/*
 * TreeMap(정렬된 map) 이용 : 중복제거+정렬
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main03 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		TreeMap <Integer, Integer> map = new TreeMap<>();
		int [] arr = new int[N];
		
		// 1. 값 넣기
		for(int i=0; i<N; i++) {	
			int num = Integer.parseInt(st.nextToken());
			map.put(num, 0);
			arr[i] = num;
		}
		
		// 2. map의 value에 정렬 결과 넣기
		int j=0;
		for(int key: map.keySet()) {
			map.put(key, j++);
		}
		
		// 3. 결과값 출력
		for(int i=0; i<N; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.println(sb);
	}
}
