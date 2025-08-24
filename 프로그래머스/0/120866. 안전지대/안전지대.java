class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    for(int x = i - 1; x <= i + 1; x++) {
                        for(int y = j - 1; y <= j + 1; y++) {
                            if(x >= 0 && x < board.length && y >= 0 && y < board.length && board[x][y] != 1) {
                                board[x][y] = 2;
                            }
                        }
                    }
                }
            }
        }
        
        
        for(int[] i : board) {
            for(int j : i) {
                if(j == 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}