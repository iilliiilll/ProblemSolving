import java.util.*;

class Solution {
    static int answer = 0;
    static int[] arr = new int[5];
    
    public int solution(int n, int[][] q, int[] ans) {
        // dfs - 오름차순
        dfs(n, q, ans, 0, 0);
        
        return answer;
    }
    
    private static void dfs(int n, int[][] q, int[] ans, int idx, int count) {
        if(count == 5) {
            compare(n, q, ans);
            return;
        }
        
        for(int i = idx; i < n; i++) {
            arr[count] = i + 1;
            dfs(n, q, ans, i + 1, count + 1);
        }
    }
    
    private static void compare(int n, int[][] q, int[] ans) {
        // arr, q 비교 -> ans와 모두 일치하면 +1
        for(int i = 0; i < ans.length; i++) {
            Set<Integer> set = new HashSet<>();
            for(int code : q[i]) set.add(code);
            
            int cnt = 0;
            for(int j = 0; j < 5 ; j++) {
                if(set.contains(arr[j])) cnt++;
            }
            
            if(cnt != ans[i]) return;
        }
        
        answer++;
    }
}