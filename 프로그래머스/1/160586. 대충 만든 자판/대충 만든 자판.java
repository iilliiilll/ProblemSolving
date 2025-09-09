import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> hm = new HashMap<>();
        
        for(String key : keymap) {
            char[] ch_arr = key.toCharArray();
            
            for(int i = 0; i < ch_arr.length; i++) {
                int tmp = hm.getOrDefault(ch_arr[i], 0);
                hm.put(ch_arr[i], tmp == 0 ? i + 1 : Math.min(tmp, i + 1));
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            char[] ch_arr = targets[i].toCharArray();
            int count = 0;
            int num;
            
            for(char ch : ch_arr) {
                num = hm.getOrDefault(ch, -1);
                
                if(num == -1) {
                    count = num;
                    break;
                } else {
                    count += num;
                }
            }
            
            answer[i] = count;
        }
        
        return answer;
    }
}