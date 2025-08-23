import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int x = Math.abs(a);
            int y = Math.abs(b);
            
            if(x == y) {
                return Integer.compare(b, a);
            } else {
                return Integer.compare(x, y);
            }
        });
        
        for(int i : numlist) {
            pq.add(i - n);
        }
        
        int[] answer = new int[numlist.length];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll() + n;
        }
        
        return answer;
    }
}