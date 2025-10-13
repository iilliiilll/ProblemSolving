import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        int n = numbers.length;
        int[] answer = new int[n];
        
        for(int i = n - 1; i >= 0; i--) {
            int cur = numbers[i];
            
            while(!deque.isEmpty() && deque.getLast() <= cur) {
                deque.removeLast();
            }
            
            answer[i] = deque.isEmpty() ? -1 : deque.getLast();
            
            deque.addLast(cur);
        }
        
        return answer;
    }
}