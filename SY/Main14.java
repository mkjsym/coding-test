// 2024.08.31
package SY;

/************** 11650. 좌표정렬하기 ***************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.StringTokenizer;
//
////Comparator
//public class Main14 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		Integer [][] point = new Integer[N][2];
//		
//		for(int i=0; i<N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			point[i][0] = Integer.parseInt(st.nextToken());
//			point[i][1] = Integer.parseInt(st.nextToken());
//		}
//		
//		Arrays.sort(point, new Comparator<Integer[]>() {
//			
//			@Override
//			public int compare(Integer[] p1, Integer[] p2) {
//				if(p1[0].equals(p2[0]))
//					return p1[1]-p2[1];
//				else
//					return p1[0]-p2[0];
//			}
//		});
//		
//		for(int i=0; i<N; i++) {
//			sb.append(point[i][0]).append(" ")
//			.append(point[i][1]).append("\n");
//		}
//		System.out.println(sb);
//	}
//}

//// 람다식
//public class Main14 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		int [][] point = new int[N][2];
//		
//		for(int i=0; i<N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			point[i][0] = Integer.parseInt(st.nextToken());
//			point[i][1] = Integer.parseInt(st.nextToken());
//		}
//		
//		Arrays.sort(point, (p1,p2)->{
//			if(p1[0]==p2[0])
//				return p1[1]-p2[1];
//			else
//				return p1[0]-p2[0];
//		});
//		
//		for(int i=0; i<N; i++) {
//			sb.append(point[i][0]).append(" ")
//			.append(point[i][1]).append("\n");
//		}
//		System.out.println(sb);
//	}
//}



/***************** 11651. 좌표 정렬하기2 *******************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main14 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		int [][] point = new int[N][2];
//		
//		for(int i=0; i<N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			point[i][0] = Integer.parseInt(st.nextToken());
//			point[i][1] = Integer.parseInt(st.nextToken());
//		}
//		
//		Arrays.sort(point, (p1,p2)->{
//			if(p1[1]==p2[1])
//				return p1[0]-p2[0];
//			else
//				return p1[1]-p2[1];
//		});
//		for(int i=0; i<N; i++) {
//			sb.append(point[i][0]).append(" ")
//			.append(point[i][1]).append("\n");
//		}
//		System.out.println(sb);
//	}
//}



/*************** 1181. 단어정렬 **************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main14 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		String[] words = set.toArray(new String[set.size()]);
		
		Arrays.sort(words, (w1,w2)->{
			if(w1.length()==w2.length()) 
				return w1.compareTo(w2);
			else 
				return w1.length() - w2.length();
		});
		
		for(int i=0; i<words.length; i++) {
			sb.append(words[i]).append("\n");
		}
		System.out.println(sb);
	}
}