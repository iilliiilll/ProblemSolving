import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        // 초 단위 배열
        int playTime = hourToSec(play_time);
        long[] timeline = new long[playTime + 1];
        
        // start, end 표시
        for (String log : logs) {
            StringTokenizer st = new StringTokenizer(log, "-");
            int start = hourToSec(st.nextToken());
            int end = hourToSec(st.nextToken());
            
            timeline[start] += 1;
            timeline[end] -= 1;
        }
        
        // 시청자 수 누적
        for (int i = 1; i <= playTime; i++) timeline[i] += timeline[i - 1];
        
        // 누적 재생시간 누적
        for (int i = 1; i <= playTime; i++) timeline[i] += timeline[i - 1];
        
        // 광고 슬라이딩 윈도우
        int advTime = hourToSec(adv_time);
        long max = timeline[advTime - 1];
        int answer = 0;
        
        for (int i = advTime; i <= playTime; i++) {
            long cur = timeline[i] - timeline[i - advTime];
            
            if (cur > max) {
                max = cur;
                answer = i - advTime + 1;
            }
        }
        
        return secToHour(answer);
    }
    
    int hourToSec(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int h = Integer.parseInt(st.nextToken()) * 3600;
        int m = Integer.parseInt(st.nextToken()) * 60;
        int s = Integer.parseInt(st.nextToken());
        
        return h + m + s;
    }
    
    String secToHour(int time) {
        StringBuilder sb = new StringBuilder();
        
        int hour = time / 3600;
        time -= hour * 3600;
        
        int min = time / 60;
        time -= min * 60;
        
        return sb.append(intToStr(hour)).append(":").append(intToStr(min)).append(":").append(intToStr(time)).toString();
    }
    
    String intToStr(int time) {
        StringBuilder sb = new StringBuilder();
        
        if (time < 10) sb.append(0).append(time);
        else sb.append(time);
        
        return sb.toString();
    }
}