import java.util.*;

class Solution {
    public String solution(String s) {
        char[] ch_arr = s.toCharArray();
        
        Arrays.sort(ch_arr);
        
        StringBuilder sb = new StringBuilder(String.valueOf(ch_arr));
        
        return sb.reverse().toString();
    }
}