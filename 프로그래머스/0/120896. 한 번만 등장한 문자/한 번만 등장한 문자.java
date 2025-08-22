import java.util.*;

class Solution {
    public String solution(String s) {
        if(s.length() == 1) {
            return s;
        }
        
        String answer = "";
        
        char[] ch_arr = s.toCharArray();
        
        Arrays.sort(ch_arr);
        
        for(int i = 0; i < ch_arr.length; i++) {
            if(i == 0) {
                if(ch_arr[0] != ch_arr[1]) {
                    answer += ("" + ch_arr[0]);
                }
            } else if(i == ch_arr.length - 1) {
                if(ch_arr[ch_arr.length - 1] != ch_arr[ch_arr.length - 2]) {
                    answer += ("" + ch_arr[ch_arr.length - 1]);
                }
            } else {
                if(ch_arr[i] != ch_arr[i - 1] && ch_arr[i] != ch_arr[i + 1]) {
                    answer += ("" + ch_arr[i]);                
                }
            }
        }
        
        return answer;
    }
}