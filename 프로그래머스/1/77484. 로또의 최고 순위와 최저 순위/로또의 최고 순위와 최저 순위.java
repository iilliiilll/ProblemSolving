class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int win = 0;
        for(int i = 0; i < win_nums.length; i++) {
            for(int j = 0; j < lottos.length; j++) {
                if(win_nums[i] == lottos[j]) {
                    win++;
                    break;
                }
            }
        }
        
        int zero = 0;
        for(int lotto : lottos) {
            if(lotto == 0) {
                zero++;
            }
        }
        
        answer[0] = win + zero == 0 ? 6 : 7 - (win + zero);
        answer[1] = answer[0] + zero > 6 ? 6 : answer[0] + zero;
            
        return answer;
    }
}