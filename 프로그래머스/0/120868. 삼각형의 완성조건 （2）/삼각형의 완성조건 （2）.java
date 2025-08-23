class Solution {
    public int solution(int[] sides) {
        int answer = 1;
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        
        // case 1) sides에서 가장 긴 변
        for(int i = 1; i < max; i++) {
            if(max < i + min) {
                answer++;
            }
        }
        
        // case 2) 나머지가 가장 긴 변
        int len = max + 1;
        
        while(true) {
            if(len < max + min) {
                answer++;
                len++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}