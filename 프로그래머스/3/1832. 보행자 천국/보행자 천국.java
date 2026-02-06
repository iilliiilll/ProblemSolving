import java.util.*;

class Solution {
    int MOD = 20170805;
    
    public int solution(int m, int n, int[][] cityMap) {
        // 0: 왼쪽, 1: 위
        int[][][] map = new int[m][n][2];
        
        // 초기화
        if (n > 1 && cityMap[0][1] != 1) map[0][1][0] = 1;
        if (m > 1 && cityMap[1][0] != 1) map[1][0][1] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                
                if (cityMap[i][j] == 0) {
                    if (j < n - 1) map[i][j + 1][0] = (map[i][j + 1][0] + map[i][j][0] + map[i][j][1]) % MOD;
                    if (i < m - 1) map[i + 1][j][1] = (map[i + 1][j][1] + map[i][j][0] + map[i][j][1]) % MOD;
                } else if (cityMap[i][j] == 2) {
                    if (j < n - 1) map[i][j + 1][0] = (map[i][j + 1][0] + map[i][j][0]) % MOD;
                    if (i < m - 1) map[i + 1][j][1] = (map[i + 1][j][1] + map[i][j][1]) % MOD;
                }
            }
        }
        
        return (map[m - 1][n - 1][0] + map[m - 1][n - 1][1]) % MOD;
    }
}