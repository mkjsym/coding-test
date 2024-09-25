// 2024.09.24
package SY.Sep;

/************ 20920. 영단어 암기는 괴로워 ************/
/*
 * HashMap으로 빈도수 저장 -> List로 변환 후 정렬
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main24 {
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> words = new HashMap<>();
		
		// 1. (단어,빈도수)를 HashMap에 넣기
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			if(str.length() >= M) {
				words.put(str, words.getOrDefault(str,0)+1);
			}
		}
		
		// 2. 단어목록을 리스트에 넣기
        ArrayList<String> wordList = new ArrayList<>(words.keySet());
		
        // 3. 정렬
        wordList.sort((w1, w2)->{
			int cnt1 = words.get(w1);
			int cnt2 = words.get(w2);
			
			if(cnt1 == cnt2) {
				if(w1.length() == w2.length())
					return w1.compareTo(w2);	// 사전순정렬
				else
					return w2.length() - w1.length();	// 길이정렬
			}
			else 
				return cnt2 - cnt1;		// 빈도수정렬
		});
		
		for(int i=0; i<wordList.size(); i++) {
			sb.append(wordList.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}
