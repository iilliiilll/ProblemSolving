class Solution {
    public long solution(int w, int h) {
//         long count = 0;
        
//         for(int x = 1; x < Math.min(w, h); x++) {
//             // 높이 내림값 (양수 기울기 사용)
//             count += (long) Math.floor((double) Math.max(w, h) * x / Math.min(w, h));
//         }
        
//         return count * 2;
        
        long W = (long) w;
        long H = (long) h;
        
        return W * H - (W + H - getGcd(w, h));
    }
    
    private static int getGcd(int w, int h) {
        if(h == 0) return w;
        return getGcd(h, w % h);
    }
}
