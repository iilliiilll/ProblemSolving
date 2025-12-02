import java.util.*;

class Solution {
    static int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        // 웅덩이 표시
        boolean[][] visited = new boolean[n][m];
        for(int[] puddle : puddles) visited[puddle[1] - 1][puddle[0] - 1] = true;
        
        // 배열 생성
        int[][] arr = new int[n][m];
        arr[0][0] = 1;
        
        // dp
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(visited[y][x]) continue;
                
                if(y > 0) arr[y][x] = (arr[y][x] + arr[y - 1][x]) % MOD;
                if(x > 0) arr[y][x] = (arr[y][x] + arr[y][x - 1]) % MOD;
            }
        }
        
        return arr[n - 1][m - 1] % MOD;
    }
}