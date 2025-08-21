class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int mid;
        
        if(num % 2 == 0) {
            mid = total / num;
            
            for(int i = 0; i < num; i++) {
                answer[i] = mid - (num / 2) + 1 + i;
            }
        } else {
            mid = total / num;
            
            for(int i = 0; i < num; i++) {
                answer[i] = mid - (num - 1) / 2 + i;
            }
        }
        
        return answer;
    }
}