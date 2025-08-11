class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] answer = new int[len + 1];
        
        for(int i = 0; i < len; i++) {
            answer[i] = num_list[i];
        }
        
        int a = num_list[len - 1];
        int b = num_list[len - 2];
        
        answer[len] = a > b ? a - b : a * 2;
        
        return answer;
    }
}