import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < lines.length; i++) {
            for(int j = lines[i][0]; j < lines[i][1]; j++) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }
        
        int answer = 0;
        
        for(int key : map.keySet()) {
            if(map.get(key) >= 2) {
                answer++;
            }
        }
        
        return answer;
    }
}