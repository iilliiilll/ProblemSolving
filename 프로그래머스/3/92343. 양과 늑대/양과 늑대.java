import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) list.add(new ArrayList<>());
        for(int[] e : edges) list.get(e[0]).add(e[1]);
        
        dfs(info, 0, 0, 0, new boolean[n], list);
        
        return answer;
    }
    
    static void dfs(int[] info, int node, int white, int black, boolean[] visited, List<List<Integer>> list) {
        if (info[node] == 0) white++;
        else black++;
        
        if (black >= white) return;
        
        answer = Math.max(answer, white);
        
        // 다음 dfs에 전달할 새로운 방문 배열
        boolean[] newVisited = visited.clone();
        newVisited[node] = true;
        
        // 방문한 노드 중 방문하지 않은 자식 방문하기
        for(int i = 0; i < list.size(); i++) {
            if (newVisited[i]) {
                for(int newNode : list.get(i)) {
                    if (!newVisited[newNode]) dfs(info, newNode, white, black, newVisited, list);
                }
            }
        }
    }
}