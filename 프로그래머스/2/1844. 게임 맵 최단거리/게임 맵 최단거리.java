import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        // 상하좌우
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        // 방문 여부 배열
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        // 큐 생성
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        // 순회
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            // 도착
            if(x == n - 1 && y == m - 1) {
                return dist;
            }
            
            // 이동 가능 여부
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m &&
                  maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny, dist + 1});
                }
            }
        }
        
        return -1;
    }
}