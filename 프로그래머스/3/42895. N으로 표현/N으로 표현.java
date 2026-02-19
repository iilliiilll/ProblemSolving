/*
dp
1. 집합 배열 생성 후 초기화
2. dp[i] = dp[j] (사칙연산) dp[i - j]
*/

import java.util.*;

class Solution {
    Set<Integer>[] dp;
    
    public int solution(int N, int number) {
        // set 배열
        dp = new HashSet[9];
        
        // 초기화
        for (int i = 1; i < dp.length; i++) dp[i] = new HashSet<>();
        
        int temp = N;
        dp[1].add(temp);
        for (int i = 2; i <= 8; i++) {
            temp = temp * 10 + N;
            dp[i].add(temp);
        }
        
        if (dp[1].contains(number)) return 1;
        
        // dp
        for (int i = 2; i <= 8; i++) {
            for (int a = 1; a < i; a++) {
                for (int n1 : dp[a]) {
                    for (int n2 : dp[i - a]) cal(i, n1, n2);
                }
            }
            
            if (dp[i].contains(number)) return i;
        }
        
        return -1;
    }
    
    void cal (int idx, int n1, int n2) {
        dp[idx].add(n1 + n2);
        dp[idx].add(n1 - n2);
        dp[idx].add(n1 * n2);
        if (n2 != 0) dp[idx].add(n1 / n2);
    }
}