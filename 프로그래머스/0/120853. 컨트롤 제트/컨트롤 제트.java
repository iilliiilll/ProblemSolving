import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int num = 0;
        StringTokenizer st = new StringTokenizer(s);
        
        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            
            if(str.equals("Z")) {
                answer -= num;
                continue;
            }
            
            num = Integer.parseInt(str);
            
            answer += num;
        }
        
        return answer;
    }
}