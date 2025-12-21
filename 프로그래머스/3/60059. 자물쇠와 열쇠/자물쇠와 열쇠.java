class Solution {
    static boolean answer = false;
    static int k;
    static int l;
    
    public boolean solution(int[][] key, int[][] lock) {
        k = key.length;
        l = lock.length;
        
        // key 배열 복사
        int[][] arr = new int[k][k];
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) arr[i][j] = key[i][j];
        }
        
        // 회전 4번
        for(int i = 0; i < 4; i++) {
            // key: lock 탐색
            find(arr, lock);
            
            // 90도 회전
            arr = rotate(arr);
            
            if (answer) return answer;
        }
        
        return false;
    }
    
    static int[][] rotate(int[][] arr) {
        int[][] temp = new int[k][k];
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) temp[i][j] = arr[k-1-j][i];
        }
        
        return temp;
    }
    
    static void find(int[][] arr, int[][] lock) {
        int n = l + k - 1;
        
        // 슬라이딩 윈도우
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // lock 복사
                int[][] board = new int[l][l];
                for(int x = 0; x < l; x++) {
                    for(int y = 0; y < l; y++) board[x][y] = lock[x][y];
                }
                
                // key 덮어쓰기
                for(int x = 0; x < k; x++) {
                    for(int y = 0; y < k; y++) {
                        int nx = x + i - (k - 1);
                        int ny = y + j - (k - 1);
                        
                        if (nx >= 0 && ny >= 0 && nx < l && ny < l) board[nx][ny] += arr[x][y];
                    }
                }
                    
                // 풀 수 있는지 확인
                if (check(board)) return;
            }
        }
    }
    
    static boolean check(int[][] arr) {
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) if (arr[i][j] != 1) return false;
        }
        
        answer = true;
        return true;
    }
}