import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        
        int[][][] arr = new int[n][n][4];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) Arrays.fill(arr[i][j], Integer.MAX_VALUE);
        }
        
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        
        // [cost, x, y, dir]
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        pq.add(new int[] {0, 0, 0, -1});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            int cost = cur[0];
            int x = cur[1];
            int y = cur[2];
            int dir = cur[3];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) continue;
                
                int nextCost = cost + 100;
                if (dir != -1 && dir != i) nextCost += 500;
                
                if (nextCost < arr[nx][ny][i]) {
                    arr[nx][ny][i] = nextCost;
                    pq.add(new int[] {nextCost, nx, ny, i});
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) answer = Math.min(answer, arr[n-1][n-1][i]);
        return answer;
    }
}