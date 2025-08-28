class Solution {
    public int solution(int price) {
        int answer = price;
        
        if(price >= 500_000) {
            answer = answer * 8 / 10;
        } else if(price >= 300_000) {
            answer = answer * 9 / 10;
        } else if(price >= 100_000) {
            answer = answer * 95 / 100;
        }
        
        return answer;
    }
}