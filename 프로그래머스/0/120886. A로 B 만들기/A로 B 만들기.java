import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] c1 = before.toCharArray();
        char[] c2 = after.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        for(int i = 0; i < c1.length; i++) {
            if(c1[i] != c2[i]) {
                return 0;
            }
        }
        
        return 1;
        
        // return new String(c1).equals(new String(c2)) ? 1 : 0;
    }
}