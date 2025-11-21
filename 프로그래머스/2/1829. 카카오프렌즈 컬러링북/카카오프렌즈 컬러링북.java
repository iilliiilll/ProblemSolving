import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        
        // 0은 true 처리
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 0) visited[i][j] = true;
            }
        }
        
        // 영역의 넓이
        int count = 0;
        int area = 0;
        
        // bfs : [x 좌표, y 좌표, 번호]
        Queue<int[]> q = new LinkedList<>();
        int[] dy = new int[] {1, -1, 0, 0};
        int[] dx = new int[] {0, 0, 1, -1};
        
        // bfs
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // 방문하지 않은 경우만
                if(!visited[i][j]) {
                    q.add(new int[] {i, j, picture[i][j]});
                    int s = 0;
                    visited[i][j] = true;
                    
                    while(!q.isEmpty()) {
                        s++;
                        int[] temp = q.poll();
                        int y = temp[0];
                        int x = temp[1];
                        int num = temp[2];
                        
                        // 상하좌우 탐색
                        for(int t = 0; t < 4; t++) {
                            int ny = y + dy[t];
                            int nx = x + dx[t];
                            
                            if(ny >= 0 && nx >= 0 && ny < m && nx < n && 
                               !visited[ny][nx] && picture[ny][nx] == num) {
                                visited[ny][nx] = true;
                                q.add(new int[] {ny, nx, num});
                            }
                        }
                    }
                    
                    count++;
                    area = Math.max(area, s);
                }
            }
        }
        
        return new int[] {count, area};
    }
}