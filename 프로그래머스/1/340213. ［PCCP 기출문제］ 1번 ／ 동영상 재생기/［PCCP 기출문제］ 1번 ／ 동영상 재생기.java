import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder sb = new StringBuilder();
        
        // String -> int 초기화
        int len = Integer.parseInt(video_len.substring(0, 2)) * 60 + Integer.parseInt(video_len.substring(3, 5));
        int cur = Integer.parseInt(pos.substring(0, 2)) * 60 + Integer.parseInt(pos.substring(3, 5));
        int start = Integer.parseInt(op_start.substring(0, 2)) * 60 + Integer.parseInt(op_start.substring(3, 5));
        int end = Integer.parseInt(op_end.substring(0, 2)) * 60 + Integer.parseInt(op_end.substring(3, 5));
        
        // 오프닝 건너뛰기
        cur = skipOpening(cur, start, end);
        
        // prev, next
        for(String command : commands) {
            cur = command.equals("prev") ? Math.max(0, cur - 10) : Math.min(len, cur + 10);
            cur = skipOpening(cur, start, end);
        }
        
        int m = cur / 60;
        int s = cur % 60;
        
        sb.append(m >= 10 ? "" : 0).append(m);
        sb.append(":");
        sb.append(s >= 10 ? "" : 0).append(s);
        
        return sb.toString();
    }
    
    private static int skipOpening(int cur, int start, int end) {
        if(start <= cur && cur <= end) {
            cur = end;
        }
        
        return cur;
    }
}