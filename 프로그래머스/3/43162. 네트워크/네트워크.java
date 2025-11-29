import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        // 컴퓨터 n개 공간 만들기
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(new ArrayList<>());
        
        // 컴퓨터 n개 넣기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && computers[i][j] == 1) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        
        // bfs
        boolean[] visited = new boolean[n];
        
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(visited, list, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void bfs(boolean[] visited, List<List<Integer>> list, int net) {
        Queue<Integer> q = new LinkedList<>();
        q.add(net);
        
        while(!q.isEmpty()) {
            int num = q.poll();
            visited[num] = true;
            
            for(int temp : list.get(num)) {
                if(!visited[temp]) q.add(temp);
            }
        }
    }
}