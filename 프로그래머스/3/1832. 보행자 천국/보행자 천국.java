/*
city_map (m x n)
    0: 통행 가능
    1: 통행 불가능
    2: 좌회전, 우회전 금지 (직진만 가능)
        오른쪽 또는 아래로 이동 가능
return 왼쪽 위->오른쪽 아래까지 이동 가능한 전체 가능한 경로 수 % MOD

1 <= m, n <= 500
출발: (0, 0). 도착: (m-1, n-1)
출발, 도착의 city_map[i][j] = 0
dfs, bfs, dp, 누적합
*/

import java.util.*;

class Solution {
    int MOD = 20170805;
    int[][][] map;
    
    public int solution(int m, int n, int[][] cityMap) {
        // 0: 왼쪽, 1: 위
        map = new int[m][n][2];
        
        // 초기화
        if (cityMap[0][1] != 1) map[0][1][0] = 1;
        if (cityMap[1][0] != 1) map[1][0][1] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                
                if (cityMap[i][j] == 0) {
                    moveRight(cityMap, i, j);
                    moveDown(cityMap, i, j);
                } else if (cityMap[i][j] == 1) {
                    continue;
                } else {
                    if (j < cityMap[0].length - 1) {
                        map[i][j + 1][0] += map[i][j][0] % MOD;
                    }
                    
                    if (i < cityMap.length - 1) {
                        map[i + 1][j][1] += map[i][j][1] % MOD;
                    }
                }
            }
        }
        
        return (map[m - 1][n - 1][0] + map[m - 1][n - 1][1]) % MOD;
    }
    
    void moveRight(int[][] cityMap, int i, int j) {
        if (j < cityMap[0].length - 1) {
            map[i][j + 1][0] += (map[i][j][0] + map[i][j][1]) % MOD;
        }
    }
    
    void moveDown(int[][] cityMap, int i, int j) {
        if (i < cityMap.length - 1) {
            map[i + 1][j][1] += (map[i][j][0] + map[i][j][1]) % MOD;
        }
    }
}