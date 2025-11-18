import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        Deque<Integer> deli = new ArrayDeque<>();
        Deque<Integer> pick = new ArrayDeque<>();

        // deque 채우기
        for(int d : deliveries) deli.addLast(d);
        for(int p : pickups) pick.addLast(p);

        // 모두 빌 때까지 반복
        while(!deli.isEmpty() || !pick.isEmpty()) {
            // 0은 모두 빼기
            while(!deli.isEmpty() && deli.getLast() == 0) deli.removeLast();
            while(!pick.isEmpty() && pick.getLast() == 0) pick.removeLast();

            // 마지막 집의 거리의 최댓값까지 가야함
            answer += Math.max(deli.size(), pick.size());

            // cap개 배달, 수거
            int d = cap;
            while(!deli.isEmpty() && d > 0) {
                if(deli.getLast() > d) {
                    deli.addLast(deli.removeLast() - d);
                    d = 0;
                } else {
                    d -= deli.removeLast();
                }
            }

            int p = cap;
            while(!pick.isEmpty() && p > 0) {
                if(pick.getLast() > p) {
                    pick.addLast(pick.removeLast() - p);
                    p = 0;
                } else {
                    p -= pick.removeLast();
                }
            }
        }
        
        return answer * 2;
    }
}