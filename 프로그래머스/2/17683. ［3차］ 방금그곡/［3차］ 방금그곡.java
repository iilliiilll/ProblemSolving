import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = -1;
        
        // # 변환
        m = change(m);
        
        for(int i = 0; i < musicinfos.length; i++) {
            // 구분해서 map에 넣기
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
            
            int time = -toMin(st.nextToken()) + toMin(st.nextToken());
            String title = st.nextToken();
            String info = change(st.nextToken());
            
            // 길이가 time인 string
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < time; j++) {
                sb.append(info.charAt(j % info.length()));
            }
            String played = sb.toString();
            
            if(played.contains(m)) {
                if(time > maxTime) {
                    answer = title;
                    maxTime = time;
                }
            }
        }
        
        return answer;
    }
    
    private static String change(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a")
                .replaceAll("B#", "b");
        
    }
    
    private static int toMin(String s) {
        StringTokenizer st = new StringTokenizer(s, ":");
        
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        
        return hour * 60 + min;
    }
}