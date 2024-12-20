// 2024.12.16
package SY.Dec;

import java.util.*;

/****** 프로그래머스 - 실패율 ******/
//class Solution {
//    public int[] solution(int N, int[] stages) {
//        int[] answer = {};
//        int fail[] = new int[N+2];  // 도달했지만 실패한 유저 수
//        int achieve[] = new int[N+1];   // statge별 총 도달유저 수
//        double result[][] = new double[N][2]; // 실패율
//        
//        Arrays.sort(stages);
//        
//        // 도달했지만 실패한 유저 수++
//        for(int i: stages){
//            if(i<=N){
//                fail[i]++;
//            }
//        }
//        // 스테이지별 총 도달유저 수
//        int total = stages.length;
//        for(int i=1; i<=N; i++){
//            achieve[i] = total;
//            total -= fail[i];
//        }
//        
//        // 스테이지별 실패율
//        for(int i=1; i<=N; i++){
//            result[i-1][0] = (achieve[i]==0) ? 0.0 : fail[i]/(double)achieve[i];
//            result[i-1][1] = i;
//        }
//
//        // 정렬
//        Arrays.sort(result, (o1, o2)->{
//            if(o1[0]==o2[0]){
//                return Double.compare(o1[1],o2[1]);
//            }
//            return Double.compare(o2[0],o1[0]);
//        });
//        
//        answer = new int[N];
//        for(int i=0; i<N; i++)
//            answer[i] = (int)result[i][1];
//        return answer;
//    }
//}

/******* 프로그래머스 - 동영상재생기 *******/
//class Solution {
//    public int convertTotal(String str){
//        StringTokenizer st = new StringTokenizer(str,":");
//        int m = Integer.parseInt(st.nextToken());
//        int s = Integer.parseInt(st.nextToken());
//        return m*60 + s;
//    }
//    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
//        String answer = "";
//        int total = convertTotal(pos);
//        int len = convertTotal(video_len);
//        int op_st = convertTotal(op_start);
//        int op_ed = convertTotal(op_end);
//        
//        for(String str: commands){
//            if(op_st <= total && total <= op_ed)
//                total = op_ed;
//            if(str.equals("prev"))
//                total = (total<10) ? 0 : total-10;
//            else if(str.equals("next"))
//                total = (total+10 > len) ? len : total+10;
//            if(op_st <= total && total <= op_ed)
//                total = op_ed;
//        }
//        
//        String result_m = String.valueOf(total / 60);
//        String result_s = String.valueOf(total % 60);
//        if(result_m.length()==1) answer += "0";
//        answer += result_m + ":";
//        if(result_s.length()==1) answer += "0";
//        answer += result_s;
//        
//        return answer;
//    }
//}


public class Man16 {

}
