class Solution {
    public int solution(int[][] board, int[][] skill) {
        // 새 배열 만들기
        int[][] arr = new int[board.length + 1][board[0].length + 1];
            
        // 누적합
        for(int[] s : skill) {
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int d = s[0] == 1 ? -s[5] : s[5];
            
            arr[r1][c1] += d;
            arr[r1][c2 + 1] += -d;
            arr[r2 + 1][c1] += -d;
            arr[r2 + 1][c2 + 1] += d;
        }
        
        // 행 누적합
        for(int r = 1; r < arr.length; r++) {
            for(int c = 0; c < arr[0].length; c++) {
                arr[r][c] += arr[r - 1][c];
            }
        }
        
        // 열 누적합
        for(int c = 1; c < arr[0].length; c++) {
            for(int r = 0; r < arr.length; r++) {
                arr[r][c] += arr[r][c - 1];
            }
        }
        
        // return
        int answer = 0;
        
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                if (board[r][c] + arr[r][c] > 0) answer++;
            }
        }
        
        return answer;
    }
}