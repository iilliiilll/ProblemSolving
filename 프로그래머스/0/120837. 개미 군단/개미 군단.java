class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        int num = hp / 5;
        answer += num;
        hp -= num * 5;
        
        num = hp / 3;
        answer += num;
        hp -= num * 3;
        
        answer += hp;
        
        return answer;
    }
}