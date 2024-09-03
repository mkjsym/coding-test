// 2024.08.23
package SY.Aug;

/************ 9063. 대지 *************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main6 {
//  public static void main(String [] args) throws Exception {
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      int N = Integer.parseInt(br.readLine());
//      int Xmax = -100001;
//      int Ymax = -100001;
//      int Xmin = 100001;
//      int Ymin = 100001;
//      
//      for(int i=0; i<N; i++) {
//          StringTokenizer st = new StringTokenizer(br.readLine());
//          int X = Integer.parseInt(st.nextToken());
//          int Y = Integer.parseInt(st.nextToken());
//          Xmax = Math.max(Xmax, X);
//          Ymax = Math.max(Ymax, Y);
//          Xmin = Math.min(Xmin, X);
//          Ymin = Math.min(Ymin, Y);
//      }
//      int result = (Xmax-Xmin)*(Ymax-Ymin); 
//      System.out.println(result);
//  }
//}



/************ 10101. 맞힌사람 ************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main6 {
//  public static void main(String [] args) throws Exception {
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      StringBuilder sb = new StringBuilder();
//      int ang1 = Integer.parseInt(br.readLine());
//      int ang2 = Integer.parseInt(br.readLine());
//      int ang3 = Integer.parseInt(br.readLine());
//      int sum = ang1 + ang2 + ang3;
//      
//      if(sum == 180) {
//      	if(ang1==60 && ang2==60)
//      		sb.append("Equilateral");
//      	else if(ang1!=ang2 && ang2!=ang3 && ang1!=ang3)
//      		sb.append("Scalene");
//      	else
//      		sb.append("Isosceles");
//      }
//      else
//      	sb.append("Error");
//      System.out.println(sb);
//  }
//}


/************** 5073. 삼각형과 세 변 *************/
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main6 {
//  public static void main(String [] args) throws Exception {
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      StringBuilder sb = new StringBuilder();
//      
//      while(true) {
//      	StringTokenizer st = new StringTokenizer(br.readLine());
//      	int len1 = Integer.parseInt(st.nextToken());
//      	int len2 = Integer.parseInt(st.nextToken());
//      	int len3 = Integer.parseInt(st.nextToken());
//      	if(len1==0 && len2==0 && len3==0) break;
//      	
//      	int sum = len1 + len2 + len3;
//      	int max = Math.max((Math.max(len1, len2)),len3);
//      	if(max >= sum-max) {
//      		sb.append("Invalid\n");
//      		continue;
//      	}
//      	
//      	if(len1==len2 && len2==len3 && len1==len3) 
//      		sb.append("Equilateral\n");
//      	else if(len1==len2 || len2==len3 || len1==len3)
//      		sb.append("Isosceles\n");
//      	else
//      		sb.append("Scalene\n");
//      }
//      System.out.println(sb);
//  }
//}

/************* 14215. 세 막대 *************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main6 {
  public static void main(String [] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int len [] = new int[3];
      
      for(int i=0; i<3; i++)
    	  len[i] = Integer.parseInt(st.nextToken());   	
      Arrays.sort(len);
      int sum = len[0] + len[1];
      
      if(len[2] >= sum)
    	  sum += sum-1;
      else
    	  sum += len[2];
      
      System.out.println(sum);
  }
}