import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int current = 0;
        int count = 0;
        
        // [개수, 서버 반납 시간]
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < 24; i++) {
            // 서버 반납
            if(!q.isEmpty()) {
                if(q.peek()[1] == i) {
                    current -= q.poll()[0];
                }
            }
            
            // 서버를 증설해야 되면
            if(players[i] >= m && current < players[i] / m) {
                // 추가할 서버의 개수
                int need = players[i] / m - current;
                
                q.add(new int[] {need, i + k});
                count += need;
                current += need;
            }
        }
        
        return count;
    }
}