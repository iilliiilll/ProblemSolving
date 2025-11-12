import java.util.*;

class Solution {
    static char[][] arr;
    static int n;
    static int m;
    static boolean[][] visited;
    
    public int solution(String[] storage, String[] requests) {
        // 문자 배열 생성
        n = storage.length;
        m = storage[0].length();
        
        arr = new char[n][m];
        
        for(int i = 0; i < n; i++) arr[i] = storage[i].toCharArray();
        
        // requests 순회
        for(String request : requests) {
            char ch = request.charAt(0);
            
            if(request.length() == 1) { // 지게차 (외부) : 외부만 '.' -> ' ' 변환
                // char -> '.'
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        if(arr[i][j] == ch) {
                            visited = new boolean[n][m];
                            if(bfs(i, j)) arr[i][j] = '.';
                        }
                    }
                }
                
                // '.' -> ' '
                changeToSpace('.');
            } else { // 크레인 (어디서든) : 모든 문자 공백으로 변환
                changeToSpace(ch);
            }
        }
        
        // return
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] != ' ') answer++;
            }
        }
        
        return answer;
    }
    
    private static void changeToSpace(char ch) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == ch) arr[i][j] = ' ';
            }
        }
    }
    
    private static boolean bfs(int row, int col) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        if(row == 0 || col == 0 || row == n - 1 || col == m - 1) return true;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col});
        visited[row][col] = true;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            
            // break
            if((x == 0 || y == 0 || x == n - 1 || y == m - 1) && arr[x][y] == ' ') return true;
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == ' ' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }
        
        return false;
    }
}