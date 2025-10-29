import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b, a);
        });
        
        for(int i = 0; i < enemy.length; i++) {
            // 적 막고 pq에 추가
            n -= enemy[i];
            pq.add(enemy[i]);
            
            // 무적권 사용할 때
            if(n < 0) {
                if(k > 0) {
                    n += pq.poll();
                    k--;
                } else {
                    return i;
                }
            }
        }
        
        return enemy.length;
    }
}