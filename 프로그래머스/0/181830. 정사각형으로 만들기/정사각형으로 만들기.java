class Solution {
    public int[][] solution(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        
        if(row == col) {
            return arr;
        }
        
        int max = Math.max(row, col);
        int[][] answer = new int[max][max];
        
        if(row > col) {
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    answer[i][j] = arr[i][j];
                }
            }
        } else {
            int[] temp = new int[col];
            
            for(int i = 0; i < col; i++) {
                answer[i] = i < row ? arr[i] : temp;
            }
        }
        
        return answer;
    }
}