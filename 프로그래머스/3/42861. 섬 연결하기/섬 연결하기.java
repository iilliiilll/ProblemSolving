import java.util.*;

class Solution {
    // prim
    public int solution(int n, int[][] costs) {
        // 방문 배열
        boolean[] visited = new boolean[n];
        
        // 그래프
        List<List<int[]>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(new ArrayList<>());
        for(int[] c : costs) {
            list.get(c[0]).add(new int[] {c[1], c[2]});
            list.get(c[1]).add(new int[] {c[0], c[2]});
        }
        
        // pq
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        pq.add(new int[] {0, 0});
        
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            
            int node = temp[0];
            int cost = temp[1];
            
            if(visited[node]) continue;
            visited[node] = true;
            answer += cost;
            
            for(int[] next : list.get(node)) {
                int nextNode = next[0];
                int nextCost = next[1];
                
                if(!visited[nextNode]) pq.add(new int[] {nextNode, nextCost});
            }
        }
        
        return answer;
    }
    
//     static int[] parent;
    
//     // kruskal
//     public int solution(int n, int[][] costs) {
//         // parnet 초기화
//         parent = new int[n];
//         for(int i = 0; i < n; i++) parent[i] = i;
        
//         // costs 정렬 (cost 오름차순)
//         Arrays.sort(costs, (a, b) -> {
//             return Integer.compare(a[2], b[2]);
//         });
        
//         // union-find
//         int answer = 0;
//         int count = 0;
        
//         for(int[] c : costs) {
//             int from = c[0];
//             int to = c[1];
//             int cost = c[2];
            
//             // 같은 그룹이 아니면 합치기
//             if (find(from) != find(to)) {
//                 union(from, to);
//                 answer += cost;
//                 count++;
//                 if (count == n - 1) break;
//             }
//         }
        
//         return answer;
//     }
    
//     private static void union(int a, int b) {
//         a = find(a);
//         b = find(b);
//         if (a != b) parent[b] = a;
//     }
    
//     private static int find(int x) {
//         if(parent[x] == x) return x;
//         return find(parent[x]);
//     }
}