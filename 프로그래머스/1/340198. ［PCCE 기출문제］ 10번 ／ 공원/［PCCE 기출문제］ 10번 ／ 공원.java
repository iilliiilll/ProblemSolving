class Solution {
    public int solution(int[] mats, String[][] park) {
        int[][] arr = new int[park.length][park[0].length];
        int max = 0;
        
        // 0행
        for(int i = 0; i < park[0].length; i++) {
            if(park[0][i].equals("-1")) {
                arr[0][i] = 1;
                max = 1;
            }
        }
        
        // 0열
        for(int i = 0; i < park.length; i++) {
            if(park[i][0].equals("-1")) {
                arr[i][0] = 1;
                max = 1;
            }
        }
        
        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j < arr[i].length; j++) {
                if(park[i][j].equals("-1")) {
                    arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1])) + 1;
                    max = Math.max(max, arr[i][j]);
                }
            }
        }
        
        int answer = -1;
        for(int mat : mats) {
            if(mat <= max) {
                answer = Math.max(mat, answer);
            }
        }
        
        return answer;
    }
}