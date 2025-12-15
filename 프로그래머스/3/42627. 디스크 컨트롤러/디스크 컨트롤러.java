import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 요청시각 빠른순
        Arrays.sort(jobs, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        
        // 소요시간 짧은순
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        
        int time = 0;
        int idx = 0;
        int total = 0;
        int n = jobs.length;
        
        while(idx < n || !pq.isEmpty()) {
            // 가능한 작업 모두 pq에 추가
            while(idx < n && jobs[idx][0] <= time) {
                pq.add(jobs[idx++]);
            }
            
            if (pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            
            // pq poll()
            int[] cur = pq.poll();
            time += cur[1];
            total += time - cur[0];
        }
        
        return total / n;
    }
}