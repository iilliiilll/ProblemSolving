import java.util.*;

class Solution {
    public String solution(String my_string) {
        char[] ch_arr = my_string.toLowerCase().toCharArray();
        
        Arrays.sort(ch_arr);
        
        return new String(ch_arr);
    }
}