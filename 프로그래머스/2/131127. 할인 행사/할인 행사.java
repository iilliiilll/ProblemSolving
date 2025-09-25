import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = discount.length - 9;
        Map<String, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            hm.put(want[i], number[i]);
        }
        
        for(int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> temp = new HashMap<>(hm);
            
            for(int j = i; j < i + 10; j++) {
                if(temp.containsKey(discount[j]) && temp.get(discount[j]) > 0) {
                    temp.put(discount[j], temp.get(discount[j]) - 1);
                } else {
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
}