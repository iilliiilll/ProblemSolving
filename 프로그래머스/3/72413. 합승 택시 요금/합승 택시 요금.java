import java.util.*;

class Solution {
    // 다익스트라: s, a, b -> 모든 지점까지의 최소 거리 구하고 각자 더하기
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 1. 그래프 초기화
        List<List<int[]>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(new ArrayList<>());
        for(int[] f : fares) {
            list.get(f[0] - 1).add(new int[] {f[1] - 1, f[2]});
            list.get(f[1] - 1).add(new int[] {f[0] - 1, f[2]});
        }
        
        // 2. 최단거리 구하기
        int[] sDist = new int[n];
        int[] aDist = new int[n];
        int[] bDist = new int[n];
        
        getDist(s - 1, sDist, list);
        getDist(a - 1, aDist, list);
        getDist(b - 1, bDist, list);
        
        // 3. return
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) answer = Math.min(answer, sDist[i] + aDist[i] + bDist[i]);
        return answer;
    }
    
    static void getDist(int start, int[] dist, List<List<int[]>> list) {
        // 배열 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // 다익스트라
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        pq.add(new int[] {start, 0});
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            
            int node = temp[0];
            int cost = temp[1];
            
            if (cost > dist[node]) continue;
            
            for(int[] next : list.get(node)) {
                int nextNode = next[0];
                int nextCost = cost + next[1];
                
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.add(new int[] {nextNode, nextCost});
                }
            }
        }
    }
}