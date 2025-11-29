import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        // bfs
        boolean[] visited = new boolean[n];
        
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(visited, n, i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void bfs(boolean[] visited, int n, int net, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(net);
        visited[net] = true;
        
        while(!q.isEmpty()) {
            int num = q.poll();
            
            for(int i = 0; i < n; i++) {
                if(!visited[i] && computers[num][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}

// import java.util.*;

// class Solution {
//     public int solution(int n, int[][] computers) {
//         int answer = 0;
        
//         boolean[] visited = new boolean[n];
        
//         for(int i = 0; i < n; i++) {
//             if(!visited[i]) {
//                 dfs(i, n, visited, computers);
//                 answer++;
//             }
//         }
        
//         return answer;
//     }
    
//     private static void dfs(int cur, int n, boolean[] visited, int[][] computers) {
//         visited[cur] = true;
        
//         for(int i = 0; i < n; i++) {
//             if(!visited[i] && computers[cur][i] == 1) {
//                 dfs(i, n, visited, computers);
//             }
//         }
//     }
// }