import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // Deque, 현재 시간, 현재 무게, 다음에 올라올 인덱스
        Deque<Integer> bridge = new ArrayDeque<>();
        int time = 0;
        int totalWeight = 0;
        int idx = 0;
        
        // 초기 상태 : 0
        for(int i = 0; i < bridge_length; i++) {
            bridge.addLast(0);
        }
        
        // 시간 단위 트럭 이동
        while(!bridge.isEmpty()) {
            time++;
            
            // 다리에서 트럭 한 칸 이동
            totalWeight -= bridge.removeFirst();
            
            // 다음 트럭이 올라올 수 있으면 추가
            if(idx < truck_weights.length) {
                if(totalWeight + truck_weights[idx] <= weight) {
                    bridge.addLast(truck_weights[idx]);
                    totalWeight += truck_weights[idx];
                    idx++;
                } else {
                    bridge.addLast(0);
                }
            }
        }
        
        return time;
    }
}