import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
//         int[] answer = new int[prices.length];
        
//         for(int i = 0; i < answer.length - 1; i++) {
//             int sec = 0;
            
//             for(int j = i + 1; j < answer.length; j++) {
//                 // 다음 인덱스로 넘어가면 +1
//                 sec++;
                
//                 // 가격이 떨어지면 종료
//                 if(prices[i] > prices[j]) {
//                     break;
//                 }
//             }
            
//             answer[i] = sec;
//         }
        
//         return answer;
        
        Deque<Integer> deque = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            while(!deque.isEmpty() && prices[deque.peekLast()] > prices[i]) {
                int idx = deque.removeLast();
                answer[idx] = i - idx;
            }
            
            deque.addLast(i);
        }
        
        while(!deque.isEmpty()) {
            int idx = deque.removeLast();
            answer[idx] = prices.length - 1 - idx;
        }
        
        return answer;
    }
}