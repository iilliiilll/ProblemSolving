import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // 정렬
        Arrays.sort(times);
        
        // 이분탐색
        long start = 0;
        long end = (long) times[times.length - 1] * n;
        
        while (start < end) {
            long mid = start + (end - start) / 2;
            
            if (getPerson(times, mid, n) < n) start = mid + 1;
            else end = mid;
        }
        
        return start;
    }
    
    private static long getPerson(int[] times, long mid, int n) {
        long person = 0;
        
        for(int time : times) {
            person += mid / time;
            if (person >= n) return n;
        }
        
        return person;
    }
}