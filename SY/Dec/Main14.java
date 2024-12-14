// 2024.12.14
package SY.Dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/****** 7576. 토마토*******/
public class Main14 {
	static int[][] graph;
	static Queue<int []> que = new LinkedList<>();
	static int M, N;
	static int cnt = 0, day = 0, result = 0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static void BFS() {
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			int cx = cur[0];
			int cy = cur[1];
			day = graph[cx][cy];
			
			for(int i=0; i<4; i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M)
					continue;
				
				if(graph[nx][ny]==0) { // 인접토마토 미방문시
					graph[nx][ny] = graph[cx][cy]+1; // 날짜 증가
					result++;	// 익은 토마토 수 증가
					que.offer(new int[] {nx,ny});
				}
			}
		}
	}
	
	public static void main(String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		cnt = 0;
		graph = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j]==1) 	// 익은토마토를 큐에 추가
					que.offer(new int[] {i,j});
				else if(graph[i][j] == 0)	// 안익은 토마토 개수 세기
					cnt++;
			}
		}

		if(cnt==0) {	// 안익은 토마토가 없으면 최소날짜 0
			System.out.println(0);
		}

		else {	
			BFS();
			System.out.println((cnt!=result) ? -1 : day-1);		// 안익은토마토 개수가 불일치하면 -1출력,
																// 아닐경우 처음에 날짜를 1부터 count했으므로 day-1 출력
		}
	}
}


/****** 이코테 6-2. 위에서 아래로 *******/
//public class Main14 {	
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		Integer arr[] = new Integer[N];
//		for(int i=0; i<N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		Arrays.sort(arr,Collections.reverseOrder());
//		for(int i: arr) {
//			sb.append(i+" ");
//		}
//		System.out.println(sb);
//	}
//}



/***** 이코테 6-3. 성적이 낮은 순서대로 학생 출력하기 ******/
//class Student{
//	String name;
//	int score;
//	public Student(String name, int score) {
//		this.name = name;
//		this.score = score;
//	}
//	public String getName() {
//		return this.name;
//	}
//	public int getScore() {
//		return this.score;
//	}
//}
//public class Main14 {	
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		ArrayList<Student> arr = new ArrayList<>();
//		for(int i=0; i<N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			arr.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken())));
//		}
//		Collections.sort(arr,(s1,s2)-> s1.getScore()-s2.getScore());
//		for(Student s: arr) {
//			sb.append(s.getName()+" ");
//		}
//		System.out.println(sb);
//	}
//}



/******* 이코테 6-4. 두 배열의 원소 교체 ********/
//public class Main14 {	
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		int A[] = new int[N];
//		int B[] = new int[N];
//		
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<N; i++) 
//			A[i] = Integer.parseInt(st.nextToken());
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<N; i++) 
//			B[i] = Integer.parseInt(st.nextToken());
//		Arrays.sort(A);
//		Arrays.sort(B);
//		for(int i=0; i<K; i++) {
//			if(A[i] < B[N-1-i]) {
//				A[i] = B[N-1-i];
//			}
//			else
//				break;
//		}
//		int sum = 0;
//		for(int i: A) {
//			sum+= i;
//		}
//		System.out.println(sum);
//	}
//}

/******* 이코테 7-2. 부품찾기 *******/
// 1) 이진탐색 이용
//public class Main14 {
//	static int Narr[];
//	static boolean BinarySearch(int start, int end, int target) {
//		while(start<=end) {
//			int mid = (start+end)/2;
//			if(Narr[mid] == target)
//				return true;
//			else if(Narr[mid]>target)
//				end = mid-1;
//			else
//				start = mid+1;
//		}
//		return false;
//	}
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		Narr = new int[N];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i=0; i<N; i++) {
//			Narr[i] = Integer.parseInt(st.nextToken());
//		}
//		Arrays.sort(Narr);
//		int M = Integer.parseInt(br.readLine());
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<M; i++) {
//			int target = Integer.parseInt(st.nextToken());
//			sb.append(BinarySearch(0,N-1,target) ? "yes " : "no ");
//		}
//		System.out.println(sb);
//	}
//}

// 2) set이용
//public class Main14 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		HashSet<Integer> Nset = new HashSet<>();
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i=0; i<N; i++) {
//			Nset.add(Integer.parseInt(st.nextToken()));
//		}
//		int M = Integer.parseInt(br.readLine());
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<M; i++) {
//			int target = Integer.parseInt(st.nextToken());
//			if(Nset.contains(target))
//				sb.append("yes ");
//			else
//				sb.append("no ");
//		}
//		System.out.println(sb);
//	}
//}



/******* 이코테 7-3. 떡볶이 떡 만들기 ********/
//public class Main14 {
//	static int arr[];
//	static int BinarySearch(int start, int end, int target) {
//		int result=0;
//		
//		while(start<=end) {
//			int mid = (start+end)/2;
//			int sum = 0;
//			for(int i=0; i<arr.length; i++) {
//				if(arr[i]>mid)
//					sum += arr[i]-mid;
//			}
//			// 목표길이보다 작음 -> 더 많이 잘라야 함 -> 왼쪽부분탐색해서 기준점을 왼쪽으로 이동 -> sum값 증가시키기
//			if(sum<target)	
//				end = mid-1;
//			else{
//				result = mid;
//				start = mid+1;
//			}
//		}
//		return result;
//	}
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		arr = new int[N];
//		st = new StringTokenizer(br.readLine());
//		int max = 0;
//		for(int i=0; i<N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//			max = Math.max(max, arr[i]);
//		}
//		System.out.println(BinarySearch(0,max,M));
//	}
//}