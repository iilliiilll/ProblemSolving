class Solution {
    public int solution(int n) {
        int x = 1_000_000_007;
        
        // dp 배열
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        // 점화식
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] % x + dp[i - 1] % x) % x;
        }
        
        return dp[n];
    }
}