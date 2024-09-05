// 2024.09.05
package SY.Sep;

/************** 10816. 숫자카드2 ****************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main05 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> cards = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			String num = st.nextToken();
			if(cards.get(num)==null)
				cards.put(num, 1);
			else
				cards.put(num, cards.get(num)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			String num = st.nextToken();
			if(cards.get(num) != null)
				sb.append(cards.get(num)).append(" ");
			else
				sb.append(0).append(" ");
		}
		System.out.println(sb);
	}
}