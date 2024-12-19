package SY.Dec;

import java.util.*;

/**** 프로그래머스 - 가장 많이 받은 선물 ****/
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        HashMap<String,Integer> map = new HashMap<>();
        int totalList[][] = new int[N][N];   // 주고받은 선물의 전체 테이블
        int giftList[][] = new int[N][2];   // 준 선물, 받은 선물 테이블
        for(int i=0; i<N; i++)
            map.put(friends[i],i);

        for(int i=0; i<gifts.length; i++){
            StringTokenizer st = new StringTokenizer(gifts[i]);
            int from = map.get(st.nextToken());
            int to = map.get(st.nextToken());
            totalList[from][to]++;   // from이 to에게 준 선물 개수++
            giftList[to][1]++;       // 받은선물++
            giftList[from][0]++;     // 준선물++
        }

        for(int i=0; i<N; i++){
            int cnt = 0;
            for(int j=0; j<N; j++){
                if(totalList[i][j] > totalList[j][i])
                    cnt++;
                else if(totalList[i][j]==totalList[j][i]){
                    int iNum = giftList[i][0] - giftList[i][1];	// 선물지수 계산
                    int jNum = giftList[j][0] - giftList[j][1];
                    if(iNum == jNum) continue;
                    if(iNum > jNum) cnt++;
                }
            }
            answer = Math.max(cnt, answer);
        }
        return answer;
    }
}


public class Main19 {
	
}
