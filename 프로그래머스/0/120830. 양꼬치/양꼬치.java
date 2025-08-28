class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        answer += 12000 * n;
        
        int free = n / 10;
        
        if(k - free > 0) {
            answer += 2000 * (k - free);
        } 
        
        return answer;
    }
}