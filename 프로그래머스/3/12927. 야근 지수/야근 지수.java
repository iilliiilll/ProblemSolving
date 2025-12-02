import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        // 내림차순 우선순위 큐에 삽입
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b, a);
        });
        
        for(int work : works) pq.add(work);
        
        // 큰 수부터 1씩 빼기
        for(int i = 0; i < n; i++) {
            int num = pq.poll();
            
            if(num > 0) pq.add(num - 1);
            if(pq.isEmpty() || num == 0) return 0;
        }
        
        long answer = 0;
        
        while(!pq.isEmpty()) answer += (int) Math.pow(pq.poll(), 2);
        
        return answer;
    }
}