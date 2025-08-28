class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int even = 0;
        
        for(int i : num_list) {
            if(i % 2 == 0) {
                even++;
            }
        }
        
        answer[0] = even;
        answer[1] = num_list.length - even;
        
        return answer;
    }
}