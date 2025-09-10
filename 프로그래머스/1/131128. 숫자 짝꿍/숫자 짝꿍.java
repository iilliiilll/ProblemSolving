import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        int[] x = new int[10];
        int[] y = new int[10];
        
        for(char ch : X.toCharArray()) {
            x[ch - '0']++;
        }
        
        for(char ch : Y.toCharArray()) {
            y[ch - '0']++;
        }
        
        for(int i = 9; i >= 0; i--) {
            for(int j = 0; j < Math.min(x[i], y[i]); j++) {
                sb.append(i);
            }
        }
        
        if(sb.length() == 0) {
            return "-1";
        } else if(sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}