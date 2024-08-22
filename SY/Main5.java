// 2024.08.22
package SY;

/********** 1193. 분수찾기 ***********/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main5 {
//    public static void main(String [] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int X = Integer.parseInt(br.readLine());
//        int n = 1;
//        int denum, num;
//        while(true) {
//        	if(X <= n*(n+1)/2)
//        		break;
//        	n++;
//        }
//        if(n%2==1) {
//        	denum = X - n*(n-1)/2;
//        	num = n-denum+1;
//        }
//        else {
//        	num = X - n*(n-1)/2;
//        	denum = n-num+1;
//        }
//        sb.append(num+"/"+denum);
//        System.out.println(sb);
//    }
//}



/*************** 11653. 소인수분해 ***************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main5 {
//	public static void main(String [] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//
//		for(int i=2; i<N/2+1; i++) {
//			while(N%i==0) {
//				sb.append(i).append("\n");
//				N/=i;
//			}
//		}
//		if(N!=1) sb.append(N);
//		
//		System.out.println(sb);
//		
//	}
//}



/************** 3009. 네번째점 **************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5 {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int x[] = new int[3];
    	int y[] = new int[3];
    	
    	for(int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
    	}
        int resultX, resultY;
    	
        if(x[0]==x[1]) resultX = x[2];
    	else if(x[0]==x[2]) resultX = x[1];
    	else	resultX = x[0];
    	
        if(y[0]==y[1]) resultY = y[2];
    	else if(y[0]==y[2]) resultY = y[1];
    	else	resultY = y[0];
        
        sb.append(resultX).append(" ").append(resultY);
        System.out.println(sb);
    }
}