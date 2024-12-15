// 2024.12.15
package SY.Dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/******* 10825. 국영수 ******/
class Student {
	String name;
	int kor, eng, math;
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public String getName() {return this.name;}
	public int getKor() {return this.kor;}
	public int getEng() {return this.eng;}
	public int getMath() {return this.math;}
}
public class Main15 {
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<Student> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			arr.add(new Student(name,kor,eng,math));
		}
		
		Collections.sort(arr,(s1,s2)->{
			String n1 = s1.getName();
			String n2 = s2.getName();
			int k1 = s1.getKor();
			int k2 = s2.getKor();
			int e1 = s1.getEng();
			int e2 = s2.getEng();
			int m1 = s1.getMath();
			int m2 = s2.getMath();
			
			if(k1 == k2) {
				if(e1 == e2) {
					if(m1 == m2) {
						return n1.compareTo(n2);
					}
					return m2-m1;
				}
				return e1-e2;
			}
			return k2-k1;
		});
		
		for(Student s: arr) {
			sb.append(s.getName()+"\n");
		}
		System.out.print(sb);
	}
}


/****** 18310. 안테나 ******/
//public class Main15 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int arr[] = new int[N];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i=0; i<N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		Arrays.sort(arr);
//		System.out.println(arr[(N-1)/2]);	// 중앙값
//	}
//}


/***** 이코테 8-2. 1로 만들기 *****/
//public class Main15 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int X = Integer.parseInt(br.readLine());
//		int dp[] = new int[X+1];
//		for(int i=2; i<=X; i++) {
//			dp[i] = dp[i-1]+1;
//			if(i%5==0 && dp[i]>dp[i/5]+1) {
//				dp[i] = dp[i/5]+1;
//			}
//			if(i%3==0 && dp[i]>dp[i/3]+1) {
//				dp[i] = dp[i/3]+1;
//			}
//			if(i%2==0 && dp[i]>dp[i/2]+1) {
//				dp[i] = dp[i/2]+1;
//			}
//		}
//		System.out.println(dp[X]);
//	}
//}

/**** 이코테 8-3. 개미전사 ****/
//public class Main15 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int arr[] = new int[N];
//		int dp[] = new int[N];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i=0; i<N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		dp[0] = arr[0];
//		dp[1] = Math.max(arr[0], arr[1]);;
//
//		// i-1번째를 털면 현재위치 못털음. 
//		// i-2번째를 털면 현재위치 털 수 있음(+arr[i])
//		for(int i=2; i<N; i++) {	
//			dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
//		}
//		System.out.println(dp[N-1]);
//	}
//}




/***** 이코테 8-4. 바닥공사 *****/
//public class Main15 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int mod = 796796;
//		int dp[] = new int[N+1];
//		dp[1] = 1;
//		dp[2] = 3;
//		// i-1까지가 채워져있으면 2x1 타일만 사용 가능.(가로길이 1)
//		// i-2까지가 채워져있으면 1x2 두개, 2x2 타일 사용 가능.(가로길이 2). dp[i-2]+dp[i-2]이므로 dp[i-2]*2
//		for(int i=3; i<=N; i++) {
//			dp[i] = (dp[i-1] + dp[i-2]*2) % mod;
//		}
//		System.out.println(dp[N]);
//	}
//}


//public class Main15 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int arr[] = new int[N];
//		int dp[] = new int[M+1];
//		Arrays.fill(dp, 10001);
//		for(int i=0; i<N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		dp[0] = 0;
//		for(int i=0; i<N; i++) {
//			for(int j=arr[i]; j<=M; j++) {
//				if(dp[j-arr[i]]!=10001) 
//					dp[j] = Math.min(dp[j-arr[i]]+1, dp[j]);
//			}
//		}
//		System.out.println(dp[M]==10001 ? -1 : dp[M]);
//		
//	}
//}

