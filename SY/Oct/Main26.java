// 2024.10.26
package SY.Oct;

/******* 13305. 주유소 ********/
/*
 * int형으로 하면 범위초과(58점). long형으로 해야 100점 나옴
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main26 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long len[] = new long[N-1];
		long price[] = new long[N];
		
		// 길이 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}
		
		// 가격 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		long min = price[0];
		long sum = min*len[0];
		
		for(int i=1; i<N-1; i++) {
			// 최저비용 갱신
			if(min>price[i]) 
				min = price[i];
			
			// 최저비용*거리만큼 충전
			sum += min*len[i];
		}
		System.out.println(sum);
	}
}
