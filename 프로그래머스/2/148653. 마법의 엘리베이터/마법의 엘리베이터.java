class Solution {
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int storey) {
        dfs(storey, 0);
        return answer;
    }
    
    private static void dfs(int storey, int count) {
        if(storey / 10 == 0) {
            count += Math.min(storey, 11 - storey);
            answer = Math.min(answer, count);
            return;
        }
        
        dfs(storey / 10, count + storey % 10);
        dfs(storey / 10 + 1, count + 10 - (storey % 10));
    }
}