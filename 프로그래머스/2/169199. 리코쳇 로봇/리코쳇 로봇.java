import java.util.*;

class Solution {
    public int solution(String[] board) {
        // char[] 로 변경 및 R, G 위치 저장
        int row = board.length;
        int col = board[0].length();
        
        char[][] arr = new char[row][col];
        
        int s1 = 0;
        int s2 = 0;
        int e1 = 0;
        int e2 = 0;
        
        for(int i = 0; i < row; i++) {
            arr[i] = board[i].toCharArray();
            
            for(int j = 0; j < col; j++) {
                if(arr[i][j] == 'R') {
                    s1 = i;
                    s2 = j;
                } else if(arr[i][j] == 'G') {
                    e1 = i;
                    e2 = j;
                }
            }
        }
        
        // bfs
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {s1, s2, 0});
        
        boolean[][] visited = new boolean[row][col];
        visited[s1][s2] = true;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int answer = -1;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int cnt = temp[2];
            
            for(int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;
                
                // 끝까지 이동
                while(true) {
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];
                    
                    if(tx < 0 || ty < 0 || tx >= row || ty >= col || arr[tx][ty] == 'D') {
                        break;
                    }
                    
                    nx = tx;
                    ny = ty;
                }
                
                if(visited[nx][ny]) {
                    continue;
                }
                
                if(arr[nx][ny] == 'G') {
                    return cnt + 1;
                } 
                
                visited[nx][ny] = true;
                q.add(new int[] {nx, ny, cnt + 1});
            }
        }
        
        return -1;
    }
}