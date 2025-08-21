class Solution {
    public int solution(int[] common) {
        int answer;
        
        int a = common[0];
        int b = common[1];
        int c = common[2];
        
        if(c - b == b - a) {
            answer = common[common.length - 1] + (c - b);
        } else {
            answer = common[common.length - 1] * (c / b);
        }
        
        return answer;
    }
}