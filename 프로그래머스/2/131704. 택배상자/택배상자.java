import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> deque = new ArrayDeque<>();
        int idx = 0;
        
        for(int i = 1; i <= order.length; i++) {
            deque.addLast(i);
            
            while(!deque.isEmpty() && deque.getLast() == order[idx]) {
                deque.removeLast();
                idx++;
            }
        }
        
        return idx;
    }
}