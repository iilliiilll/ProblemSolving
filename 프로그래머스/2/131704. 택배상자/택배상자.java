import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> x = new ArrayDeque<>();
        Deque<Integer> y = new ArrayDeque<>();
        
        // x에 order개만큼 넣기
        for(int i = 1; i <= order.length; i++) {
            x.addLast(i);
        }
        
        // 순회
        int box = 0;
        
        while(true) {
            // 보조 컨테이너
            if(!y.isEmpty() && y.getLast() == order[box]) {
                y.removeLast();
                box++;
                continue;
            }
            
            // 메인 컨테이너
            if(!x.isEmpty()) {
                if(x.getFirst() == order[box]) {
                    x.removeFirst();
                    box++;
                } else {
                    y.addLast(x.removeFirst());
                }
            } else {
                break;
            }
        }
        
        return box;
    }
}