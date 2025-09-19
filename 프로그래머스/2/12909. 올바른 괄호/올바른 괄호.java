import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] ch_arr = s.toCharArray();
        
        int idx = 0;
        for(char ch : ch_arr) {
            idx += ch == ('(') ? 1 : -1;
            
            if(idx < 0) {
                return false;
            }
        }
        
        return idx == 0 ? true : false;
    }
}