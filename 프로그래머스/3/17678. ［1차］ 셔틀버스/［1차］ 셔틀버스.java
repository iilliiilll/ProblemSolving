import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // 처음 도착 시간
        int start = toMin("09:00");
        
        // timetable String -> int 변환
        int[] time = new int[timetable.length];
        for(int i = 0; i < time.length; i++) time[i] = toMin(timetable[i]);
        Arrays.sort(time);
        
        // deque
        Deque<Integer> q = new ArrayDeque<>();
        for(int tt : time) q.addLast(tt);
        
        // 막차 전까지 모두 빼기
        for(int i = 0; i < n - 1; i++) {
            int curTime = start + i * t;
            
            for(int j = 0; j < m; j++) {
                if (!q.isEmpty() && q.peekFirst() <= curTime) q.pollFirst();
                else break;
            }
        }
        
        // 막차 시간에서 m - 1번 뽑기
        int curTime = start + (n - 1) * t;
        
        for(int i = 0; i < m - 1; i++) {
            if (!q.isEmpty() && q.peekFirst() <= curTime) q.pollFirst();
        }
        
        // 막차 + 마지막 순서
        if (!q.isEmpty() && q.peekFirst() <= curTime) return toStr(q.pollFirst() - 1);
        else return toStr(curTime);
    }
    
    private static int toMin(String t) {
        StringTokenizer st = new StringTokenizer(t, ":");
        return 60 * Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
    }
    
    private static String toStr(int t) {
        int h = t / 60;
        int m = t % 60;
        
        StringBuilder sb = new StringBuilder();
        return sb.append(h < 10 ? 0 : "").append(h).append(":").append(m < 10 ? 0 : "").append(m).toString();
    }
}