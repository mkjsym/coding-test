// 2024.09.23
package SY.Sep;

/********** 2108. 통계학 **********/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main23 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int sum = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			// HashMap에 (정수, 빈도) 저장
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}
			else {
				map.put(arr[i], 1);
			}
			
			sum += arr[i];
		}
		// 1. 산술평균
		sb.append(Math.round(sum/(double)N)).append("\n");
		
		// 2. 중앙값
		Arrays.sort(arr);
		sb.append(arr[N/2]).append("\n");
		
		// 3. 최빈값
		int maxval = Collections.max(map.values());
		ArrayList<Integer> maxkey = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			if(value == maxval) {
				maxkey.add(key);
				if(maxkey.size()==2) break;
			}
		}
		sb.append(maxkey.get(maxkey.size()-1)).append("\n");
		
		// 4. 범위
		sb.append(arr[N-1]-arr[0]);
		System.out.println(sb);
	}
}
