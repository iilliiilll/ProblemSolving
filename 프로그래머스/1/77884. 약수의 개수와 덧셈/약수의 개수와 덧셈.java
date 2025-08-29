class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            answer += get(i) % 2 == 0 ? i : -i;
        }
        
        return answer;
    }
    
    private int get(int num) {
        int cnt = 0;
        
        for(int i = 1; i * i <= num; i++) {
            if(i * i == num) {
                cnt++;
            } else if(num % i == 0) {
                cnt += 2;
            }
        }
        
        return cnt;
    }
}