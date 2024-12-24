// 2024.12.24
package SY.Dec;

/****** 프로그래머스 - 이웃한 칸 ******/
class Solution3 {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int dx[] = new int[]{-1,1,0,0};
        int dy[] = new int[]{0,0,-1,1};
        
        for(int i=0; i<4; i++){
            int nx = h+dx[i];
            int ny = w+dy[i];
            if(nx<0 || nx>=n || ny<0 || ny>=n)
                continue;
            if(board[nx][ny].equals(board[h][w]))
                answer++;
        }
        return answer;
    }
}

/****** 프로그래머스 - 데이터 분석 *******/
//import java.util.*;
//
//class Solution3 {
//    public int getIdx(String ext){
//        if(ext.equals("code")) return 0;
//        else if(ext.equals("date")) return 1;
//        else if(ext.equals("maximum")) return 2;
//        else return 3;
//    }
//    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
//        int[][] answer = {};
//        ArrayList<int[]> arr = new ArrayList<>();
//        int idx = getIdx(ext);
//        
//        for(int i=0; i<data.length; i++){
//            if(data[i][idx] < val_ext)
//                arr.add(data[i]);
//        }
//        
//        int sIdx = getIdx(sort_by);
//        Collections.sort(arr, (o1,o2)->{
//            return o1[sIdx] - o2[sIdx];
//        });
//        
//        answer = new int[arr.size()][4];
//        for(int i=0; i<arr.size(); i++){
//            answer[i] = arr.get(i);
//        }
//        return answer;
//    }
//}


/****** 프로그래머스 - 달리기 경주 *****/
//import java.util.*;
//
//class Solution3 {
//    public String[] solution(String[] players, String[] callings) {
//        String[] answer = {};
//        HashMap<String,Integer> map = new HashMap<>();
//        for(int i=0; i<players.length; i++){
//            map.put(players[i],i);
//        }
//        for(int i=0; i<callings.length; i++){
//            int prev = map.get(callings[i]);    // 이전등수
//            
//            String tmp = players[prev];
//            players[prev] = players[prev-1];
//            players[prev-1] = tmp;
//       
//            map.put(players[prev],prev);
//            map.put(players[prev-1],prev-1);
//        }
//        answer = new String[players.length];
//        for(int i=0; i<players.length; i++)
//            answer[i] = players[i];
//        
//        return answer;
//    }
//}




public class Main24 {

}
