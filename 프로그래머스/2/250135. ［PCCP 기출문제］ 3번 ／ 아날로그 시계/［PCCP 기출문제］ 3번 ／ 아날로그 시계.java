class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 초로 변환
        int start = toSec(h1, m1, s1);
        int end = toSec(h2, m2, s2);
        
        int answer = count(end) - count(start);
        
        if(start == 0 || start == 43200) answer += 1;
        
        return answer;
    }
    
    private static int toSec(int h, int m, int s) {
        return (h * 60 * 60) + (m * 60) + s;
    }
    
    private static int count(int time) {
        int ms = (time * 59) / 3600;
        int hs = (time * 719) / 43200;
        
        int dup = time >= 43200 ? 1 : 0;
        
        return ms + hs - dup;
    }
}