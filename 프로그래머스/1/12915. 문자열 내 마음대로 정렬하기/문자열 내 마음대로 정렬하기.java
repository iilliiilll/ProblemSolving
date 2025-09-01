import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Queue<String> pq = new PriorityQueue<>((a, b) -> {
            char c1 = a.charAt(n);
            char c2 = b.charAt(n);
            
            if(c1 == c2) {
                return a.compareTo(b);
            }
            
            return c1 - c2;
        });
        
        for(String str : strings) {
            pq.add(str);
        }
        
        String[] answer = new String[pq.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll();
        }
        
        return answer;
    }
}