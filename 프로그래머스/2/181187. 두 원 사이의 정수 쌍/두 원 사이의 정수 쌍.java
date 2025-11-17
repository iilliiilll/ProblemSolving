class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        // x = 1 ~ max
        for(long x = 1; x <= r2; x++) {
            long y1, y2, num;
            
            if(x < r1) {
                y1 = (long) Math.ceil(Math.sqrt((r1 + x) * (r1 - x)));
                y2 = (long) Math.floor(Math.sqrt((r2 + x) * (r2 - x)));
                
                num = y2 - y1 + 1;
            } else {
                num = (long) Math.floor(Math.sqrt((r2 + x) * (r2 - x))) + 1;
            }
            
            answer += num;
        }
        
        return answer * 4;
    }
}