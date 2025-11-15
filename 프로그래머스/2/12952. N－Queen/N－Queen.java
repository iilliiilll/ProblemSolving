class Solution {
    static int answer = 0;
    static boolean[] col;
    static boolean[] left; // row + col : 0 ~ 2 * n - 2
    static boolean[] right; // row - col : -(n - 1) ~ n - 1
    
    public int solution(int n) {
        col = new boolean[n];
        left = new boolean[2 * n - 1];
        right = new boolean[2 * n - 1];
        
        dfs(n, 0);
        
        return answer;
    }
    
    private static void dfs(int n, int row) {
        if(row == n) {
            answer++;
            return;
        }
        
        for(int j = 0; j < n; j++) {
            // 열, 대각선 모두 가능하면
            if(!col[j] && !left[row + j] && !right[row - j + n - 1]) {
                col[j] = left[row + j] = right[row - j + n - 1] = true;
                dfs(n, row + 1);
                col[j] = left[row + j] = right[row - j + n - 1] = false;
            }
        }
    }
}