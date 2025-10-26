import java.util.*;

class Solution {
    static List<int[]>[] list;
    static int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        // List, dist, Queue 초기화
        list = new ArrayList[N + 1];
        dist = new int[N + 1];
        
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[1] = 0;
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        pq.add(new int[] {0, 1});
        
        // road 삽입
        for(int i = 0; i < road.length; i++) {
            int s = road[i][0];
            int e = road[i][1];
            int t = road[i][2];
            
            list[s].add(new int[] {e, t});
            list[e].add(new int[] {s, t});
        }
        
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            int cost = temp[0];
            int start = temp[1];
            
            if(cost > dist[start]) {
                continue;
            }
            
            for(int[] next : list[start]) {
                int nextStart = next[0];
                int nextCost = cost + next[1];
                
                if(nextCost < dist[nextStart]) {
                    dist[nextStart] = nextCost;
                    pq.add(new int[] {nextCost, nextStart});
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            if(dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}