import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 1. 우선순위 큐에 모두 넣기
        Queue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville) {
            queue.add(s);
        }
        
        // 2. 2개 이상이고, 가장 낮은 스코빌이 K보다 작으면 섞기
        while(queue.size() > 1 && queue.peek() < K) {
            int n1 = queue.poll();
            int n2 = queue.poll();

            queue.add(n1 + n2 * 2);
            
            answer++;
        }
        
        // 3. 남은 1개가 K보다 작다면 -1 리턴
        return queue.size() == 1 && queue.peek() < K ? -1 : answer;
    }
}