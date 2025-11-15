import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 제일 늦게 시작하는 것부터 하나씩 자르기
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // return b[0] - a[0];
            
            // 제일 빨리 끝나는 거
            return a[1] - b[1];
        });
        
        // pq에 삽입
        for(int[] target : targets) {
            pq.add(new int[] {target[0], target[1]});
        }
        
        // 순회
        // double shoot = pq.poll()[0] + 0.1;
        double shoot = pq.poll()[1] - 0.1;
        answer++;
            
        while(!pq.isEmpty()) {
            int[] temp = pq.peek();
            int from = temp[0];
            int to = temp[1];
            
            if(shoot > (double) from) {
                pq.poll();
            } else {
                answer++;
                shoot = (double) to - 0.1;
                pq.poll();
            }
            
            // if(shoot < (double) to) {
            //     pq.poll();
            // } else {
            //     answer++;
            //     shoot = (double) from + 0.1;
            //     pq.poll();
            // }
        }
        
        return answer;
    }
}