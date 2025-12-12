import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        boolean[] visited = new boolean[n];
        int[] answer = new int[sources.length];
        int[] all = new int[n];
        Arrays.fill(all, -1);
        
        // List<List<>> 그래프 만들기
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(new ArrayList<>());
        for(int[] r : roads) {
            list.get(r[0] - 1).add(r[1] - 1);
            list.get(r[1] - 1).add(r[0] - 1);
        }
        
        // bfs (목적지 -> 출발지)
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {destination - 1, 0});
        visited[destination - 1] = true;
        all[destination - 1] = 0;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            
            int cur = temp[0];
            int depth = temp[1];
            
            for(int next : list.get(cur)) {
                if (!visited[next]) {
                    all[next] = depth + 1;
                    visited[next] = true;
                    q.add(new int[] {next, depth + 1});
                }
            }
        }
        
        for(int i = 0; i < answer.length; i++) answer[i] = all[sources[i] - 1];
        
        return answer;
    }
}