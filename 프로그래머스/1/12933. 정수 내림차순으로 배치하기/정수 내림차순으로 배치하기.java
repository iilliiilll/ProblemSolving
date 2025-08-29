import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        
        char[] ch_arr = String.valueOf(n).toCharArray();
        
        Arrays.sort(ch_arr);
        
        for(char ch : ch_arr) {
            sb.append(ch);
        }
        
        return Long.parseLong(sb.reverse().toString());
    }
}