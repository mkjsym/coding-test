// 2024.12.25
package SY.Dec;

/******** 프로그래머스 - 추억점수 *********/
import java.util.*;

class Solution4 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i],yearning[i]);
        }
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                answer[i] += map.getOrDefault(photo[i][j],0);
            }
        }
        return answer;
    }
}

/******* 프로그래머스 - 공원산책 ******/
//import java.util.*;
//class Solution4 {    
//    public int Direction(String dir){
//        if(dir.equals("N")) return 0;
//        else if(dir.equals("S")) return 1;
//        else if(dir.equals("W")) return 2;
//        else return 3;
//    }
//    
//    public int[] solution(String[] park, String[] routes) {
//        int[] answer = new int[2];
//        int[] dx = new int[]{-1,1,0,0};
//        int[] dy = new int[]{0,0,-1,1};
//        int x=0, y=0;
//        // 시작점 찾기
//        for(int i=0; i<park.length; i++){
//            for(int j=0; j<park[i].length(); j++){
//                if(park[i].charAt(j) == 'S'){
//                    x = i;
//                    y = j;
//                    break;
//                }
//            }
//        }
//        
//        for(int i=0; i<routes.length; i++){
//            StringTokenizer st = new StringTokenizer(routes[i]);
//            String dir = st.nextToken();
//            int n = Integer.parseInt(st.nextToken());
//            int d = Direction(dir);
//            int nx=x, ny=y;
//            boolean isSuccess = true;
//            for(int j=0; j<n; j++){
//                nx += dx[d];
//                ny += dy[d];
//                // 범위벗어날경우
//                if(nx<0 || nx>=park.length || ny<0 || ny>=park[0].length()){
//                    isSuccess = false; 
//                    break;
//                }
//                // 장애물 만날경우
//                if(park[nx].charAt(ny)=='X'){
//                    isSuccess = false;
//                    break;
//                }
//            }
//            if(isSuccess){
//                x = nx; 
//                y = ny;                
//            }
//        }
//        answer[0] = x;
//        answer[1] = y;
//        
//        return answer;
//    }
//}

public class Main25 {
	
}
