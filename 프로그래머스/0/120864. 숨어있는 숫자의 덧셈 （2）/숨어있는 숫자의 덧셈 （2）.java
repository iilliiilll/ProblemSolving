import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String str = my_string.replaceAll("[a-zA-Z]", " ");
        StringTokenizer st = new StringTokenizer(str);
        
        while(st.hasMoreTokens()) {
            answer += Integer.parseInt(st.nextToken());
        }
        
        return answer;
    }
}