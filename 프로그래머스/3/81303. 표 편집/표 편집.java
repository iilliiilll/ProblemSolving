import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // deque, 배열
        Deque<int[]> delete = new ArrayDeque<>();
        int[] prev = new int[n];
        int[] next = new int[n];
        
        // 초기값 설정 (null이면 -1)
        for(int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        next[n - 1] = -1;
        
        // 순회
        for(String c : cmd) {
            StringTokenizer st = new StringTokenizer(c, " ");
            char ch = st.nextToken().charAt(0);
            
            if (ch == 'D' || ch == 'U') {
                int step = Integer.parseInt(st.nextToken());
                for(int i = 0; i < step; i++) k = ch == 'D' ? next[k] : prev[k];
            } else if (ch == 'C') {
                delete.addLast(new int[] {prev[k], k, next[k]});
                
                if (prev[k] == -1) { // 맨 앞
                    prev[next[k]] = prev[k];
                } else if (next[k] == -1) { // 맨 뒤
                    next[prev[k]] = next[k];
                } else { // 중간
                    next[prev[k]] = next[k];
                    prev[next[k]] = prev[k];
                }
                
                // 커서 이동
                if (next[k] == -1) k = prev[k];
                else k = next[k];
            } else if (ch == 'Z') {
                int[] temp = delete.pollLast();
                
                int front = temp[0];
                int num = temp[1];
                int end = temp[2];
                
                if (front == -1) { // 맨 앞
                    prev[end] = num;
                } else if (end == -1) { // 맨 뒤
                    next[front] = num;
                } else { // 중간
                    next[front] = num;
                    prev[end] = num;
                }
            }
        }
        
        // return
        boolean[] answer = new boolean[n];
        for(int[] d : delete) answer[d[1]] = true;
        
        StringBuilder sb = new StringBuilder();
        for(boolean b : answer) sb.append(b ? "X" : "O");
        return sb.toString();
    }
}