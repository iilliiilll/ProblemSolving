import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        // 그래프 초기화
        List<List<Integer>> win = new ArrayList<>();
        List<List<Integer>> lose = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }
        
        for(int[] result : results) {
            win.get(result[0] - 1).add(result[1] - 1);
            lose.get(result[1] - 1).add(result[0] - 1);
        }
        
        // i의 순위를 매길 수 있는지 확인
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            if (bfs(win, n, i) + bfs(lose, n, i) == n - 1) count++;
        }
        
        return count;
    }
    
    static int bfs(List<List<Integer>> list, int n, int cur) {
        int count = 0;
        boolean[] visited = new boolean[n];
        
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(cur);
        visited[cur] = true;
        
        while(!q.isEmpty()) {
            int num = q.pollFirst();
            
            for(int l : list.get(num)) {
                if (!visited[l]) {
                    visited[l] = true;
                    q.addLast(l);
                    count++;
                }
            }
        }
        
        return count;
    }
}