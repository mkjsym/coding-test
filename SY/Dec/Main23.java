// 2024.12.23
package SY.Dec;

/******* 프로그래머스 - 지폐접기 ******/
class Solution2 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int wallet_max = Math.max(wallet[0],wallet[1]);
        int wallet_min = Math.min(wallet[0],wallet[1]);
        
        while(Math.min(bill[0],bill[1])>wallet_min || Math.max(bill[0],bill[1])>wallet_max){
            if(bill[0]>bill[1])
                bill[0] /= 2;
            else
                bill[1] /= 2;
            answer++;
        }
        return answer;
    }
}

/***** 프로그래머스 - 붕대감기 ******/
//class Solution2 {
//    public int solution(int[] bandage, int health, int[][] attacks) {
//        int answer = health;
//        int t = bandage[0];
//        int x = bandage[1];
//        int y = bandage[2];
//        int lastAttack = attacks[attacks.length-1][0];
//        int idx = 0;
//        int time = 0;    // 연속성공
//        
//        for(int i=1; i<=lastAttack; i++){
//            // 공격 : 연속성공 초기화, 체력감소, 죽음여부 판단
//            if(i==attacks[idx][0]){
//                time = 0;
//                answer -= attacks[idx][1];
//                if(answer<=0) return -1;
//                idx++;
//            }
//            // 붕대감기 : 체력증가, 연속성공시 추가회복, 기술종료후 연속성공초기화
//            else{
//                answer += x;
//                time++;
//                if(time == t){
//                    answer += y;
//                    time = 0;
//                }
//                if(answer > health) answer = health;
//            }
//        }
//        return answer;
//    }
//}

public class Main23 {
}
