import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        
        for(char ch : s.toCharArray()) {
            if(ch == ' ') {
                sb.append(ch);
                idx = 0;
            } else {
                sb.append(idx % 2 == 0 ? Character.toUpperCase(ch) : Character.toLowerCase(ch));
                idx++;
            }
        }
        
        return sb.toString();
    }
}