import java.util.*; 

class Solution {
    static boolean[] visited;
    static String[] answer;
    static boolean finished = false;
    
    public String[] solution(String[][] tickets) { 
        // 초기화
        visited = new boolean[tickets.length];
        answer = new String[tickets.length + 1];
        answer[0] = "ICN";
        
        // 사전순 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (!a[0].equals(b[0])) return a[0].compareTo(b[0]);
            return a[1].compareTo(b[1]);
        });
        
        // dfs
        dfs(tickets, "ICN", 0);
        
        return answer;
    }
    
    private static void dfs(String[][] tickets, String from, int depth) {
        if (depth == tickets.length) {
            finished = true;
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if (!finished && !visited[i] && from.equals(tickets[i][0])) {
                visited[i] = true;
                
                answer[depth + 1] = tickets[i][1];
                dfs(tickets, tickets[i][1], depth + 1);
                
                visited[i] = false;
                
                if (finished) return;
            }
        }
    }
}