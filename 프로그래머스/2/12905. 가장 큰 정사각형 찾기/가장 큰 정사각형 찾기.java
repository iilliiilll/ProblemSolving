class Solution {
    public int solution(int [][]board) {
        int len = 0;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                len = Math.max(len, board[i][j]);
                
                int y = i - 1;
                int x = j - 1;
                
                // 범위 내, 현재 값이 1, 주변 값이 1 이상
                if(x >= 0 && y >= 0 && y < board.length && x < board[0].length && board[i][j] == 1 && board[y][x] > 0 && board[y + 1][x] > 0 && board[y][x + 1] > 0) board[i][j] = Math.min(board[y][x], Math.min(board[y + 1][x], board[y][x + 1])) + 1;
                
                len = Math.max(len, board[i][j]);
            }
        }
        
        return len * len;
    }
}