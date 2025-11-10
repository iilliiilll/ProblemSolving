class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int level = Integer.MAX_VALUE;
        int start = 1;
        int end = 300000;
        
        while(start != end) {
            // mid에서의 소요 시간
            int mid = (start + end) / 2;
            long midTime = getTime(diffs, times, mid);
            
            // 오래 걸리면 레벨 증가, 적게 걸리면 레벨 감소
            if(midTime > limit) {
                start = mid + 1;
            } else {
                level = Math.min(level, mid);
                end = mid;
            }
        }
        
        return level;
    }
    
    private static long getTime(int[] diffs, int[] times, int level) {
        long time = times[0];
        
        for(int i = 1; i < diffs.length; i++) {
            if(diffs[i] <= level) time += times[i];
            // 전체 시간 = 틀린 횟수 * (time_cur + time_prev) + time_cur
            else time += ((diffs[i] - level) * (times[i] + times[i - 1])) + times[i];
        }
        
        return time;
    }
}