class Solution {
    public long solution(int n) {
        long answer = 0;
        long a = 1;
        long b = 1;
        
        if(n == 1) {
            return 1;
        }
        
        for(int i = 2; i <= n; i++) {
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
        }
        
        return answer;
    }
}