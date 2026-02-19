/*
dp
1. State, Throw 클래스 생성
2. 가능한 점수 List 생성
3. dp 배열 생성 후 초기화
4. dp: 횟수가 작을 경우 or 횟수가 같고 싱글/불 합이 더 클 경우 교체
*/

import java.util.*;

class State {
    int cnt; // 던진 횟수
    int sum; // 싱글, 불 합
    
    State (int cnt, int ssum) {
        this.cnt = cnt;
        this.sum = sum;
    }
}

class Throw {
    int score; // 점수
    boolean isSingleBool; // 싱글, 불인지
    
    Throw (int score, boolean isSingleBool) {
        this.score = score;
        this.isSingleBool = isSingleBool;
    }
}

class Solution {
    public int[] solution(int target) {
        // 가능한 점수
        List<Throw> throwList = new ArrayList<>();
        
        throwList.add(new Throw(50, true));
        for (int i = 1; i <= 20; i++) {
            throwList.add(new Throw(i, true));
            throwList.add(new Throw(i * 2, false));
            throwList.add(new Throw(i * 3, false));
        }
        
        // dp 배열
        State[] dp = new State[target + 1];

        // 노드 배열 초기화
        dp[0] = new State(0, 0);
        for (int i = 1; i <= target; i++) dp[i] = new State(100_000, 0);
        
        // dp
        for (int i = 1; i <= target; i++) {
            for (Throw t : throwList) {
                int score = t.score;
                boolean isSingleBool = t.isSingleBool;
                
                if (i - score < 0) continue;
                
                int newCnt = dp[i - score].cnt + 1;
                int newSum = dp[i - score].sum + (isSingleBool ? 1 : 0);

                if (newCnt < dp[i].cnt || (newCnt == dp[i].cnt && newSum > dp[i].sum)) {
                    dp[i].cnt = newCnt;
                    dp[i].sum = newSum;
                }
            }
        }
        
        return new int[] {dp[target].cnt, dp[target].sum};
    }
}