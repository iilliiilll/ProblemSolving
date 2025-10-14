class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        // 0행 복사
        int n = land.length;
        int[][] arr = new int[n][4];
        
        for(int col = 0; col < 4; col++) {
            arr[0][col] = land[0][col];
        }
        
        // 1행 ~ n-1행
        for(int row = 1; row < n; row++) {
            for(int col = 0; col < 4; col++) {
                // 최댓값 구하기
                arr[row][col] = land[row][col] + getMax(arr, row, col);
            }
        }
        
        for(int col = 0; col < 4; col++) {
            answer = Math.max(answer, arr[n - 1][col]);
        }
        
        return answer;
    }
    
    private static int getMax(int[][] arr, int row, int col) {
        int num = 0;
        
        for(int i = 0; i < 4; i++) {
            if(col != i) {
                num = Math.max(num, arr[row - 1][i]);
            }
        }
        
        return num;
    }
}