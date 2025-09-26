import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> hm = new HashMap<>();
        
        for(String[] cloth : clothes) {
            String kind = cloth[1];
            hm.put(kind, hm.getOrDefault(kind, 1) + 1);
        }
        
        int answer = 1;
        for(int v : hm.values()) {
            answer *= v;
        }
        
        return answer - 1;
    }
}