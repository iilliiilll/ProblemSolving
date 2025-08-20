class Solution {
    static int[][] answer;
    static int number = 1;
    
    public int[][] solution(int n) {
        answer = new int[n][n];
        
        for(int i = 0; i < (n + 1) / 2; i++) {
            getArr(i);
        }
        
        return answer;
    }
    
    private static void getArr(int idx) {
        int x = idx;
        int y = idx;
        int cnt = answer.length - (idx * 2 + 1);
        int i;
        
        if(cnt == 0) {
            answer[idx][idx] = number;
            return;
        }
        
        
        for(i = 0; i < cnt; i++) {
            answer[x][y++] = number++;
        }
        
        for(i = 0; i < cnt; i++) {
            answer[x++][y] = number++;
        }
        
        for(i = 0; i < cnt; i++) {
            answer[x][y--] = number++;
        }
        
        for(i = 0; i < cnt; i++) {
            answer[x--][y] = number++;
        }
    }
}