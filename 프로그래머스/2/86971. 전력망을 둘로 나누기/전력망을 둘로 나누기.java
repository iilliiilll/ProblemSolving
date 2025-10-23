import java.util.*;

class Solution {
    static List<Integer>[] list;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        list = new ArrayList[n + 1];
        
        // 그래프 초기화
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            list[v1].add(v2);
            list[v2].add(v1);
        }
        
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            boolean[] visited = new boolean[n + 1];
            
            list[v1].remove(Integer.valueOf(v2));
            list[v2].remove(Integer.valueOf(v1));
            
            int cnt = dfs(1, visited);
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
            
            list[v1].add(v2);
            list[v2].add(v1);
        }
        
        return answer;
    }
    
    private static int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int cnt = 1;
        
        for(int next : list[v]) {
            if(visited[next]) {
                continue;
            }
            
            cnt += dfs(next, visited);
        }
        
        return cnt;
    }
}