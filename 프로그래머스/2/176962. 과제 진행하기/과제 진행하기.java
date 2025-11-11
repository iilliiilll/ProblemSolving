import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> finish = new ArrayList<>();
        Deque<String[]> waiting = new ArrayDeque<>();
        
        // 시작시간 오름차순
        Arrays.sort(plans, (a, b) -> {
            return a[1].compareTo(b[1]);
        });
        
        // 하나씩 실행
        for(int i = 0; i < plans.length - 1; i++) {
            String name1 = plans[i][0];
            int start1 = toMin(plans[i][1]);
            int playTime1 = Integer.parseInt(plans[i][2]);
            
            String name2 = plans[i + 1][0];
            int start2 = toMin(plans[i + 1][1]);
            int playTime2 = Integer.parseInt(plans[i + 1][2]);
            
            if(start2 - start1 < playTime1) { // 시간이 부족하면 - waiting에 추가
                waiting.addLast(new String[] {name1, Integer.toString(playTime1 - (start2 - start1))});
            } else if(start2 - start1 == playTime1) { // 시간이 딱 맞으면 - finish에 추가
                finish.add(name1);
            } else { // 시간이 남으면 - finish에 추가 -> 남은 시간만큼 waiting에 있는 과제 수행
                finish.add(name1);
                
                int restTime = (start2 - start1) - playTime1;
                
                while(!waiting.isEmpty() && restTime > 0) {
                    String name = waiting.getLast()[0];
                    int waitingTime = Integer.parseInt(waiting.getLast()[1]);
                    
                    if(restTime < waitingTime) { // waiting 과제를 못끝내면 - 남은시간 변경
                        waiting.getLast()[1] = Integer.toString(waitingTime - restTime);
                    } else { // waiting 과제를 끝내면 - 제거
                        finish.add(waiting.removeLast()[0]);
                    }
                    
                    restTime -= waitingTime;
                }
            }
        }
        
        // 나머지 처리 - 마지막 과제 -> waiting 과제
        finish.add(plans[plans.length - 1][0]);
        while(!waiting.isEmpty()) finish.add(waiting.removeLast()[0]);
        
        // return
        String[] answer = new String[finish.size()];
        for(int i = 0; i < finish.size(); i++) answer[i] = finish.get(i);
        return answer;
    }
    
    private static int toMin(String str) {
        return Integer.parseInt(str.substring(0, 2)) * 60 + Integer.parseInt(str.substring(3, 5));
    }
}