// 2024.10.15
package SY.Oct;

/*********** 16139. 인간-컴퓨터 상호작용 *************/
/*
 * a-z까지 알파벳별 누적합을 저장 후 구간합 구하기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main15 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		int q = Integer.parseInt(br.readLine());
		int alArr[][] = new int[26][S.length()+1];
		
		// 알파벳 별 누적합 구하기
		for(int i=1; i<=S.length(); i++) {
			for(int j=0; j<26; j++) {
				alArr[j][i] = alArr[j][i-1];
			}
			int idx = S.charAt(i-1) - 97;
			alArr[idx][i]++;
		}
		
		for(int i=0; i<q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			// 구간합 구하기
			int result = alArr[a-97][r+1] - alArr[a-97][l];
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
