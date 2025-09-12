class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++) {
            // 정상 출근 여부
            boolean b = true;
            
            // 일주일 출근시간
            for(int j = 0; j < timelogs[i].length; j++) {
                // 주말 제외
                int curDay = (startday - 1 + j) % 7;
                if(curDay == 5 || curDay == 6) {
                    continue;
                }
                
                // 희망 출근시간
                int startTime = schedules[i] + 10;
                
                if(startTime % 100 > 59) {
                    startTime += 100;
                    startTime -= 60;
                }
                
                // 실제 출근시각
                int endTime = timelogs[i][j];
                
                // 출근시각 비교
                if(startTime < endTime) {
                    b = false;
                    break;
                }
            }
            
            if(b) {
                answer++;
            }
        }
        
        return answer;
    }
}