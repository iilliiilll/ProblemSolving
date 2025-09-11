import java.util.*;

class Solution {
    static Map<Character, Integer> hm = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            String s = survey[i];
            char ch;
            
            if(choice < 4) {
                ch = s.charAt(0);
                hm.put(ch, hm.getOrDefault(ch, 0) + (4 - choice));
            } else if(choice > 4) {
                ch = s.charAt(1);
                hm.put(ch, hm.getOrDefault(ch, 0) + (choice - 4));
            }
        }
        
        sb.append(getChar('R', 'T'));
        sb.append(getChar('C', 'F'));
        sb.append(getChar('J', 'M'));
        sb.append(getChar('A', 'N'));
        
        return sb.toString();
    }
    
    private static char getChar(char c1, char c2) {
        int i1 = hm.containsKey(c1) ? hm.get(c1) : 0;
        int i2 = hm.containsKey(c2) ? hm.get(c2) : 0;
        char ch;
        
        if(i1 > i2) {
            ch = c1;
        } else if(i1 < i2) {
            ch = c2;
        } else {
            ch = c1 < c2 ? c1 : c2;
        }
        
        return ch;
    }
}