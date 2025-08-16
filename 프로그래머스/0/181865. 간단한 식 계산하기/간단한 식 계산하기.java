import java.util.*;

class Solution {
    public int solution(String binomial) {
        StringTokenizer st = new StringTokenizer(binomial);
        
        int a = Integer.parseInt(st.nextToken());
        String op = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        
        switch(op) {
            case "+": 
                answer = a + b;
                break;
            case "-": 
                answer = a - b;
                break;
            case "*": 
                answer = a * b;
                break;
        }
        
        return answer;
    }
}