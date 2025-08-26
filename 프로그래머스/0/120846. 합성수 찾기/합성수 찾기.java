class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            if(getB(i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static boolean getB(int n) {
        if(n == 1 || n == 2 || n == 3) {
            return false;
        }
        
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return true;
            }
        }
        
        return false;
    }
}