class Solution {
    static char[][] arr;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++) {
            arr = new char[5][5];
            for(int j = 0; j < 5; j++) arr[j] = places[i][j].toCharArray();
            
            if(good()) answer[i] = 1;
        }
        
        return answer;
    }
    
    private static boolean good() {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                // 거리두기 준수x
                if(arr[i][j] == 'P' && !check(i, j)) return false;
            }
        }
        
        // 거리두기 준수o
        return true;
    }
    
    private static boolean check(int row, int col) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        // 거리 1
        for(int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            
            if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && arr[nx][ny] == 'P') return false;
        }
        
        // 거리 2
        for(int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            
            if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && arr[nx][ny] == 'O') {
                for(int j = 0; j < 4; j++) {
                    int mx = nx + dx[j];
                    int my = ny + dy[j];
                    
                    if((mx != row || my != col) && mx >= 0 && my >= 0 && mx < 5 && my < 5 && arr[mx][my] == 'P') return false;
                }
            }
        }
        
        return true;
    }
}