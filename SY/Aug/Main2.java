// 2024.08.19
package SY.Aug;

/************** 1157. 단어공부 *****************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;

//public class Main2 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String s = br.readLine();
//		s = s.toUpperCase();
//		
//		int alArr [] = new int[26];
//		int max = 0;
//		int maxIdx = '?';
//		
//		for(int i=0; i<s.length(); i++) {
//			int al = s.charAt(i)-'A';
//			alArr[al]++;
//			if(alArr[al] > max) {
//				max = alArr[al];
//				maxIdx = al;
//			}
//			else if(alArr[al] == max) {
//				maxIdx = '?' -'A';
//			}
//		}
//		char ans = (char)(maxIdx+'A');
//		System.out.println(ans);
//	}
//}



/******************** 2941. 크로아티아 **********************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main2 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String s = br.readLine();
//		int cnt = 1;
//		
//		for(int i=1; i<s.length(); i++) {
//			if(s.charAt(i) == '=') {
//				if(s.charAt(i-1) == 'c' || s.charAt(i-1) == 's')
//					continue;
//				else if(i!=1 && (s.charAt(i-1) == 'z' && s.charAt(i-2) == 'd'))
//					cnt--;
//				else if(s.charAt(i-1) == 'z')
//					continue;
//			}
//			else if(s.charAt(i) == '-') {
//				if(s.charAt(i-1) == 'c' || s.charAt(i-1) == 'd')
//					continue;
//			}
//			else if(s.charAt(i) == 'j') {
//				if(s.charAt(i-1) == 'l' || s.charAt(i-1) == 'n')
//					continue;
//				else
//					cnt++;
//			}
//			else
//				cnt++;
//		}
//		System.out.println(cnt);
//	}
//}




/****************** 1316. 그룹단어체커 *********************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main2 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//
//		int cnt = 0;
//		Boolean group = false;
//		
//		for(int i=0; i<N; i++) {
//			String s = br.readLine();
//			for(int j=0; j<s.length(); j++) {
//				char now = s.charAt(j);
//				if(j!=s.length()-1 && now != s.charAt(j+1)) {
//					if(s.substring(j+1).contains(Character.toString(now))) {
//						group = false;
//						break;
//					}
//					else 
//						group = true;
//				}
//				else
//					group = true;
//			}
//			if(group) cnt++;
//		}
//		System.out.println(cnt);	
//	}
//}




/***************** 10798. 세로읽기 ********************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList <Character>[] arr = new ArrayList[5];
		for(int i=0; i<5; i++) {
			arr[i] = new ArrayList<Character>();
		}
		int lenmax = 0;
		
		for(int n=0; n<5; n++) {
			String s = br.readLine();
			if(s.length()>lenmax)
				lenmax = s.length();
			for(int m=0; m<s.length(); m++) {
				arr[n].add(s.charAt(m));
			}
		}
		
		for(int m=0; m<lenmax; m++) {
			for(int n=0; n<5; n++) {
				if(arr[n].size()-1 < m)
					sb.append("");
				else
					sb.append(arr[n].get(m));
			}
		}
		System.out.println(sb);
	}
}