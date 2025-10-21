import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum = 0;
        int left = 0;
        int right = 0;
        int length = sequence.length;
        
        while(right < sequence.length) {
            sum += sequence[right];
            
            while(sum >= k) {
                if(sum == k && right - left < length) {
                    length = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
                
                sum -= sequence[left++];
            }
            
            right++;
        }
        
        return answer;
        
//         Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
//             // 길이 짧은 순 - 시작 인덱스 작은 순
//             int aLen = a[1] - a[0];
//             int bLen = b[1] - b[0];
            
//             return aLen != bLen ? aLen - bLen : a[0] - b[0];
//         });
        
//         // [인덱스, 값]
//         Deque<int[]> deque = new ArrayDeque<>();
//         int sum = 0;
    
//         for(int i = 0; i < sequence.length; i++) {
//             // 삽입
//             deque.addLast(new int[] {i, sequence[i]});
//             sum += sequence[i];
            
//             // 합 확인
//             if(sum == k) {
//                 pq.add(new int[] {deque.getFirst()[0], deque.getLast()[0]});
//                 sum -= deque.removeFirst()[1];
//             }
            
//             while(sum > k) {
//                 sum -= deque.removeFirst()[1];
                
//                 if(sum == k) {
//                     pq.add(new int[] {deque.getFirst()[0], deque.getLast()[0]});
//                 }
//             }
//         }
        
//         // return
//         return pq.poll();
    }
}