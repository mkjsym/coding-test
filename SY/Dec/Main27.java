// 2024.12.27
package SY.Dec;

import java.util.*;

/****** 프로그래머스 - 게임 맵 최단거리 *****/
// BFS문제
class Solution5 {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};    
    static boolean isSuccess = false;
    static Queue<int []> que = new LinkedList<>();
    public static int BFS(int [][] maps, int x, int y){
        que.offer(new int[]{x,y});
        while(!que.isEmpty()){
            int cur[] = que.poll();
            int cx = cur[0];
            int cy = cur[1];
            if(cx==maps.length-1 && cy==maps[0].length-1)
                isSuccess = true;
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx<0 || nx>=maps.length || ny<0 || ny>=maps[0].length)
                    continue;
                if(maps[nx][ny]==1){
                    maps[nx][ny] = maps[cx][cy]+1;
                    que.offer(new int[]{nx,ny});
                }
            }
        }
        if(isSuccess)
            return maps[maps.length-1][maps[0].length-1];
        return -1;
    }
    public int solution(int[][] maps) {
        int answer = 0;
        answer = BFS(maps,0,0);
        return answer;
    }
}

/****** 프로그래머스 - 바탕화면 정리 *****/
//class Solution5 {
//    public int[] solution(String[] wallpaper) {
//        int[] answer = new int[4];
//        int lux = 51;
//        int luy = 51;
//        int rdx = 0;
//        int rdy = 0;
//        
//        for(int i=0; i<wallpaper.length; i++){
//            for(int j=0; j<wallpaper[i].length(); j++){
//                if(wallpaper[i].charAt(j)=='#'){
//                    if(i<lux) lux = i;
//                    if(i>rdx) rdx = i;
//                    if(j<luy) luy = j;
//                    if(j>rdy) rdy = j;
//                }
//            }
//        }
//        answer[0] = lux;
//        answer[1] = luy;
//        answer[2] = rdx+1;
//        answer[3] = rdy+1;
//        
//        return answer;
//    }
//}

public class Main27 {

}
