class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        
        int idx = 0;
        
        for(int a = 0; a < answer.length; a++) {
            for(int b = 0; b < answer[0].length; b++) {
                answer[a][b] = num_list[idx++];
            }
        }
        
        return answer;
    }
}