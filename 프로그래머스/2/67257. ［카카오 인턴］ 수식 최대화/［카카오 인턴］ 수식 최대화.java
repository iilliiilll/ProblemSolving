import java.util.*;

class Solution {
    static long answer = 0;
    static boolean[] visited = new boolean[3];
    static char[] ops = new char[] {'+', '-', '*'};
    static char[] order = new char[3];
    
    public long solution(String expression) {
        op(expression, 0);
        return answer;
    }
    
    private static void op(String expression, int cnt) {
        // 3개 다 채우면 list 만들고 dfs
        if(cnt == 3) {
            List<String> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(expression, "+-*", true);
            while(st.hasMoreTokens()) list.add(st.nextToken());
            
            dfs(list, 0);
            return;
        }
        
        for(int i = 0; i < 3; i++) {
            if(!visited[i]) {
                visited[i] = true;
                order[cnt] = ops[i];
                op(expression, cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    private static void dfs(List<String> list, int count) {
        // 연산자 3개 다 사용하면 절댓값 구하기
        if(count == 3) {
            long val = Math.abs(Long.parseLong(list.get(0)));
            answer = Math.max(answer, val);
            return;
        }
        
        Deque<String> deque = new ArrayDeque<>();
        char op = order[count];
        
        for(int i = 0; i < list.size(); i++) {
            String token = list.get(i);
            
            if(token.equals(String.valueOf(op))) {
                long before = Long.parseLong(deque.pollLast());
                long after = Long.parseLong(list.get(++i));
                
                if(op == '+') deque.addLast(String.valueOf(before + after));
                else if(op == '-') deque.addLast(String.valueOf(before - after));
                else deque.addLast(String.valueOf(before * after));
            } else {
                deque.addLast(token);
            }
        }
        
        dfs(new ArrayList<>(deque), count + 1);
    }
}