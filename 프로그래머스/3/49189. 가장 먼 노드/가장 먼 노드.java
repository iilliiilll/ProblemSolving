import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n];
        
        // 그래프 생성 -> 초기화 -> 추가
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(new ArrayList<>());
        for(int[] e : edge) {
            list.get(e[0] - 1).add(e[1] - 1);
            list.get(e[1] - 1).add(e[0] - 1);
        }
        
        // bfs(노드, 깊이)로 각 노드의 깊이 저장
        // List<Integer> depth = new ArrayList<>();
        int[] depth = new int[n];
        int idx = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0] = true;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            
            int curNode = temp[0];
            int curDepth = temp[1];
            
            for(int nextNode : list.get(curNode)) {
                if(!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.add(new int[] {nextNode, curDepth + 1});
                    // depth.add(curDepth + 1);
                    depth[idx++] = curDepth + 1;
                }
            }
        }
        
        // 정렬 -> 리턴
//         depth.sort((a, b) -> {
//             return Integer.compare(b, a);
//         });
        
//         int answer = 0;
//         int max = depth.get(0);
//         for(int cnt : depth) {
//             if(cnt != max) break;
//             answer++;
//         }
//         return answer;
        int max = -1;
        for(int d : depth) max = Math.max(max, d);
        
        int answer = 0;
        for(int d : depth) {
            if (max == d) answer++;
        }
        
        return answer;
    }
}