class Solution {
    public int solution(int balls, int share) {
        if(share > balls - share) {
            share = balls - share;
        }
        
        double answer = 1;
        
        for(int i = 1; i <= share; i++) {
            answer *= (double) balls--;
            answer /= (double) i;
        }
        
        return (int) answer;
    }
}