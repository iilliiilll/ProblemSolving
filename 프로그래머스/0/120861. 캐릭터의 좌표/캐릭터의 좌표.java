class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int row = (board[0] - 1) / 2;
        int col = (board[1] - 1) / 2;
        
        for(String key : keyinput) {
            if(key.equals("up")) {
                answer[1] = Math.min(col, answer[1] + 1);
            } else if(key.equals("down")) {
                answer[1] = Math.max(-col, answer[1] - 1);
            } else if(key.equals("left")) {
                answer[0] = Math.max(-row, answer[0] - 1);
            } else if(key.equals("right")) {
                answer[0] = Math.min(row, answer[0] + 1);
            }
        }
        
        return answer;
    }
}