import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Deque<Long> deque1 = new ArrayDeque<>();
        Deque<Long> deque2 = new ArrayDeque<>();
        
        // 큐의 합
        long q1 = 0;
        long q2 = 0;
        
        for(long q : queue1) {
            q1 += q;
            deque1.addLast(q);
        }
        
        for(long q : queue2) {
            q2 += q;
            deque2.addLast(q);
        }
        
        // 홀수면 return
        if((q1 + q2) % 2 == 1) {
            return -1;
        }
        
        // 순회
        int limit =  (deque1.size() + deque2.size()) * 4;
        
        while(true) {
            if(q1 > q2) {
                long num = deque1.removeFirst();
                deque2.addLast(num);
                
                q1 -= num;
                q2 += num;
            } else if(q1 < q2) {
                long num = deque2.removeFirst();
                deque1.addLast(num);
                
                q2 -= num;
                q1 += num;
            } else {
                break;
            }
            
            if(deque1.isEmpty() || deque2.isEmpty() || limit < answer) {
                return -1;
            }
            
            answer++;
        }
        
        return answer;
    }
}