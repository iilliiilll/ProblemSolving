class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String color = board[h][w];
        
        if(h > 0 && color.equals(board[h - 1][w])) {
            answer++;
        }
        
        if(w > 0 && color.equals(board[h][w - 1])) {
            answer++;
        }
        
        if(h < board.length - 1 && color.equals(board[h + 1][w])) {
            answer++;
        } 
        
        if(w < board.length - 1 && color.equals(board[h][w + 1])) {
            answer++;
        }
        
        return answer;
    }
}