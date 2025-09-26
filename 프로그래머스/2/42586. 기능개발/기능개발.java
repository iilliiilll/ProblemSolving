import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] day = new int[speeds.length];
        List<Integer> al = new ArrayList<>();
        Deque<Integer> ad = new ArrayDeque<>();
        
        for(int i = 0; i < day.length; i++) {
            day[i] = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            
            if(!ad.isEmpty() && ad.getFirst() < day[i]) {
                al.add(ad.size());
                ad.clear();
            }
            
            ad.addLast(day[i]);
        }
        
        if(!ad.isEmpty()) {
            al.add(ad.size());
        }
        
        int[] answer = new int[al.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }
}