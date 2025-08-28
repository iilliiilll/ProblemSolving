import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;
        int answer = 0;
        int cnt = 0;
        
        for(int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(int i : map.values()) {
            max = Math.max(max, i);
        }
        
        for(int i : map.keySet()) {
            if(max == map.get(i)) {
                answer = i;
                cnt++;
            }
        }
        
        return cnt == 1 ? answer : -1;
    }
}