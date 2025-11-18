import java.util.*;

class Solution {
    public int solution(int[] cards) {
        Map<Integer, Integer> group = new HashMap<>();
        
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b, a);
        });
        
        
        // 그룹 나누기 (그룹 번호, 개수)
        int g = 0;
        
        for(int i = 0; i < cards.length; i++) {
            if(cards[i] == -1) continue;
            
            int next = cards[i];
            cards[i] = -1;
            group.put(g, 1);
            
            while(cards[next - 1] != -1) {
                int temp = cards[next - 1];
                cards[next - 1] = -1;
                next = temp;
                
                group.put(g, group.getOrDefault(g, 0) + 1);
            }
            
            g++;
        }
        
        // 그룹 개수가 1개면 return
        if(group.size() == 1) return 0;
        
        // 그룹 개수 구하기
        for(int key : group.keySet()) {
            pq.add(group.get(key));
        }
        
        // 그룹 개수가 여러 개면 가장 큰 수 두 개 꺼내서 곱하고 return
        return pq.poll() * pq.poll();
    }
}