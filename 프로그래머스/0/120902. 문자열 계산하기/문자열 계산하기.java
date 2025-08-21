import java.util.*;

class Solution {
    public int solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string);
        
        int answer = Integer.parseInt(st.nextToken());
        
        while(st.hasMoreTokens()) {
            char ch = (st.nextToken()).charAt(0);
            int num = Integer.parseInt(st.nextToken());
            
            answer += ch == '+' ? num : num * (-1);
        }

        return answer;
    }
}