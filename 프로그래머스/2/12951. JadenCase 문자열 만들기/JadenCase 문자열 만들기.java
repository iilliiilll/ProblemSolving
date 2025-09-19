import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        
        while(st.hasMoreTokens()) {
            char[] ch_arr = st.nextToken().toCharArray();
            
            for(int i = 0; i < ch_arr.length; i++) {
                if(i == 0) {
                    sb.append(Character.isDigit(ch_arr[i]) ? ch_arr[i] : Character.toUpperCase(ch_arr[i]));
                } else {
                    sb.append(Character.toLowerCase(ch_arr[i]));
                }
            }
        }
        
        return sb.toString();
    }
}