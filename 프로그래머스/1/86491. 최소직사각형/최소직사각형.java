class Solution {
    public int solution(int[][] sizes) {
        int row = 0;
        int col = 0;
        
        for(int[] size : sizes) {
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);
            
            row = Math.max(row, max);
            col = Math.max(col, min);
        }
        
        return row * col;
    }
}