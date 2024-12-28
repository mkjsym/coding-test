// 2024.12.28
package SY.Dec;

/******* 프로그래머스 - 공원 *******/
// 완전탐색
import java.util.*;
class Solution6 {
    // 현재 위치에서 돗자리 깔 수 있는지 여부 판단하는 함수
    public static boolean findMat(int n, int m, int mat, String[][] park){
        if(n+mat>park.length || m+mat>park[0].length)
            return false;
        for(int j=n; j<n+mat; j++){
            for(int k=m; k<m+mat; k++){
                if(!park[j][k].equals("-1")){
                    return false;
                }
            }
        }
        return true;
    }
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        Arrays.sort(mats);
        // 돗자리 큰 순으로 완전탐색
        for(int i=mats.length-1; i>=0; i--){
            int mat = mats[i];
            for(int n=0; n<park.length; n++){
                for(int m=0; m<park[0].length; m++){
                    if(park[n][m].equals("-1")){
                        if(findMat(n,m,mat,park)){
                            return mat;           
                        }
                    }
                }
            }
        }   
        return answer;
    }
}
