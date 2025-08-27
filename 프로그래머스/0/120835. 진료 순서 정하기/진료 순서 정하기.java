import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        Map<Integer, Integer> map = new HashMap<>();
        int idx = answer.length;
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = emergency[i];
        }
        
        Arrays.sort(answer);
        
        for(int i : answer) {
            map.put(i, idx--);
        }
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = map.get(emergency[i]);
        }
        
        return answer;
    }
}