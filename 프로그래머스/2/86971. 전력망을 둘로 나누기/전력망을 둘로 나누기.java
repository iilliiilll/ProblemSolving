import java.util.*;

class Solution {
    // static List<Integer>[] list;
    // static int answer = Integer.MAX_VALUE;
    static int[][] graph;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new int[n+1][n+1];
        
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph[v1][v2] = 0;
            graph[v1][v2] = 0;
            
            answer = Math.min(answer, bfs(n, v1));
            
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        return answer;
//         list = new ArrayList[n + 1];
        
//         // 그래프 초기화
//         for(int i = 1; i <= n; i++) {
//             list[i] = new ArrayList<>();
//         }
        
//         for(int i = 0; i < wires.length; i++) {
//             int v1 = wires[i][0];
//             int v2 = wires[i][1];
            
//             list[v1].add(v2);
//             list[v2].add(v1);
//         }
        
//         for(int i = 0; i < wires.length; i++) {
//             int v1 = wires[i][0];
//             int v2 = wires[i][1];
            
//             boolean[] visited = new boolean[n + 1];
            
//             list[v1].remove(Integer.valueOf(v2));
//             list[v2].remove(Integer.valueOf(v1));
            
//             int cnt = dfs(1, visited);
//             int diff = Math.abs(cnt - (n - cnt));
//             answer = Math.min(answer, diff);
            
//             list[v1].add(v2);
//             list[v2].add(v1);
//         }
        
//         return answer;
    }
    
    private static int bfs(int n, int x) {
        boolean[] visited = new boolean[n + 1];
        int cnt = 1;
        
        Queue<Integer> q = new LinkedList<>();
        visited[x] = true;
        q.add(x);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 1; i <= n; i++) {
                if(graph[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    cnt++;
                }
            }
        }
        
        return Math.abs(cnt - (n - cnt));
    }
    
//     private static int dfs(int v, boolean[] visited) {
//         visited[v] = true;
//         int cnt = 1;
        
//         for(int next : list[v]) {
//             if(visited[next]) {
//                 continue;
//             }
            
//             cnt += dfs(next, visited);
//         }
        
//         return cnt;
//     }
}