import java.util.*;

class Solution {
    static Set<Set<String>> set = new HashSet<>();
    static boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        
        // dfs : 깊이
        dfs(user_id, banned_id, 0, new HashSet<>());
        
        return set.size();
    }
    
    private static void dfs(String[] user_id, String[] banned_id, int depth, Set<String> mini) {
        // Set 추가 시 복사해서 넣기
        if (depth == banned_id.length) {
            set.add(new HashSet<>(mini));
            return;
        }
        
        for(int i = 0; i < user_id.length; i++) {
            if(!visited[i] && same(user_id[i].toCharArray(), banned_id[depth].toCharArray())) {
                visited[i] = true;
                mini.add(user_id[i]);
                
                dfs(user_id, banned_id, depth + 1, mini);
                
                mini.remove(user_id[i]);
                visited[i] = false;
            }
        }
    }
    
    private static boolean same(char[] ch1, char[] ch2) {
        if (ch1.length != ch2.length) return false;
        
        for(int i = 0; i < ch1.length; i++) {
            if (ch2[i] == '*') continue;
            else if (ch1[i] != ch2[i]) return false;
        }
        
        return true;
    }
}