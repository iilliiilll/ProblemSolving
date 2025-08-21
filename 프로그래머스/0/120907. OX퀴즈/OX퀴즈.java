import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        StringTokenizer st;
        
        for(int i = 0; i < quiz.length; i++) {
            st = new StringTokenizer(quiz[i]);
            
            int x = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            int y = Integer.parseInt(st.nextToken());
            st.nextToken();
            int z = Integer.parseInt(st.nextToken());
            
            if(s.equals("+")) {
                answer[i] = x + y == z ? "O" : "X";
            } else {
                answer[i] = x - y == z ? "O" : "X";
            }
        }
        
        return answer;
    }
}