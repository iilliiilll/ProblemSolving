import java.util.*;

class Solution {
    static int MAX = 500;
    
    public int solution(int[][] info, int n, int m) {
        int size = info.length;
        int[][] dp = new int[size + 1][m];
        
        // 최댓값으로 초기화
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], MAX);
        
        dp[0][0] = 0;
            
        for(int i = 1; i <= size; i++) {
            // 흔적
            int a = info[i - 1][0];
            int b = info[i - 1][1];
            
            // 최솟값 계산
            for(int j = 0; j < m; j++) {
                // A가 선택
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);
                
                // B가 선택
                if(j + b < m) dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]);
            }
        }
        
        // 최솟값 구하기
        int answer = MAX;
        
        for(int j = 0; j < m; j++) answer = Math.min(answer, dp[size][j]);
        
        return answer >= n ? -1 : answer;
    }
}