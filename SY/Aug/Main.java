// 2024.08.18
package SY.Aug;

/********* 5597. 과제 안 내신 분..? **********/

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;

////ArrayList
//public class Main{
//	public static void main(String [] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		
//		ArrayList<Integer> students = new ArrayList<>();
//		
//		int n=30;
//		for(int i=0; i<n; i++) {
//			students.add(i+1);
//		}
//		
//		for(int i=0; i<n-2; i++) {
//			int sub = Integer.parseInt(br.readLine());
//			students.remove(Integer.valueOf(sub));
//		}
//		for(int i=0; i<students.size(); i++) {
//			sb.append(students.get(i)).append("\n");
//		}
//		
//		System.out.println(sb);
//	}
//}	

////배열
//public class Main{
//	public static void main(String [] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		
//		int [] students = new int[30];
//		for(int i=0; i<students.length; i++) {
//			students[i] = i+1;
//		}
//		for(int i=0; i<students.length-2; i++) {
//			int sub = Integer.parseInt(br.readLine())-1;
//			students[sub] = 0;
//		}
//		for(int i=0; i<students.length; i++) {
//			if(students[i]!=0)
//				sb.append(students[i]).append("\n");
//		}
//		System.out.print(sb);
//	}
//}	





/************** 3052. 나머지 ***************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//// HashSet
//public class Main{
//	public static void main(String [] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		Set<Integer> set = new HashSet<>();
//		
//		for(int i=0; i<10; i++) {
//			int n = Integer.parseInt(br.readLine()) % 42;
//			set.add(n);
//		}
//		
//		System.out.println(set.size());
//	}
//}

//// 배열
//public class Main{
//	public static void main(String [] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		Boolean remArr[] = new Boolean[42];
//		int cnt = 0;
//		
//		for(int i=0; i<42; i++)
//			remArr[i] = false;
//		
//		for(int i=0; i<10; i++) {
//			int n = Integer.parseInt(br.readLine()) % 42;
//			remArr[n] = true;
//		}
//		
//		for(int i=0; i<remArr.length; i++) {
//			if(remArr[i]==true)
//				cnt++;
//		}
//		System.out.println(cnt);
//	}
//}




/********** 1152. 단어의 개수 ***********/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main{
//	public static void main(String [] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str = br.readLine().trim();
//		int len=str.length();
//		int word=0;
//		
//		for(int i=0; i<len; i++) {
//			char c = str.charAt(i);
//			if(c == ' ' || i==len-1)
//				word++;
//		}
//		System.out.print(word);
//	}
//}



/************* 2908. 상수 ************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		String a = st.nextToken();
//		String b = st.nextToken();
//		
//		int nA = Integer.parseInt("" + a.charAt(2) + a.charAt(1) + a.charAt(0));
//		int nB = Integer.parseInt("" + b.charAt(2) + b.charAt(1) + b.charAt(0));
//		
//		
//		System.out.println(Math.max(nA, nB));
//	}
//}





/*********** 5622. 다이얼 ************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> h = new HashMap<>();
		
		int n, al = 65;
		
		for(int i=2; i<=9; i++) {	// 알파벳-숫자 매칭
			if(i==7 || i==9) n = 4;
			else n = 3;
			
			for(int j=1; j<=n; j++) {
				h.put((char)al++,i);
			}
		}
		
		String str = br.readLine();
		int time = 0;
		
		for(int i=0; i<str.length(); i++) {
			time += h.get(str.charAt(i))+1;
		}
		
		System.out.println(time);
	}
}