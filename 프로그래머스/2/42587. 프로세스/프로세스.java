import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> ad = new ArrayDeque<>();
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        
        // ArrayDeque, PriorityQueue에 넣기
        for(int i = 0; i < priorities.length; i++) {
            ad.addLast(new int[] {i, priorities[i]});
            pq.add(priorities[i]);
        }
        
        // 꺼내면서 [0] == location이면 리턴
        int count = 1;
        
        while(!ad.isEmpty()) {
            // 꺼내기
            int[] num = ad.removeFirst();
            
            // 최댓값이면 실행, 아니면 다시 넣기
            if(num[1] == pq.peek()) {
                pq.remove();
                
                if(num[0] == location) {
                    return count;
                }
                
                count++;
            } else {
                ad.add(num);
            }
        }
        
        return count;
    }
}