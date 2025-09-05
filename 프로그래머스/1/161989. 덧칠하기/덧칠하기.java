class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int location = 0;
        
        for(int paint : section) {
            if(location <= paint) {
                location = paint + m;
                answer++;
            }
        }
        
        return answer;
    }
}