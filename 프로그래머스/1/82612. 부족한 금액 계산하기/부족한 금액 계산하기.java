class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;
        
        for(int i = 0; i < count; i++) {
            sum += (long) price * (i + 1);
        }
        
        answer = money - sum;
        
        if(answer < 0) {
            return -answer;
        } else {
            return 0;
        }
    }
}