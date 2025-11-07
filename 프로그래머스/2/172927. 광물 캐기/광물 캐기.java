import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        // 우선순위 큐 : [다이아, 철, 돌] (개수)
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // 피로도 높은 순
            if(a[0] != b[0]) return b[0] - a[0];
            else if(a[1] != b[1]) return b[1] - a[1];
            else return b[2] - a[2];
        });
        
        int total = picks[0] + picks[1] + picks[2];
        
        // 우선순위 큐에 삽입
        for(int i = 0; i < minerals.length; i+=5) {
            int[] m = new int[3];
            
            for(int j = i; j < Math.min(i + 5, minerals.length); j++) {
                if(minerals[j].startsWith("d")) m[0]++;
                else if(minerals[j].startsWith("i")) m[1]++;
                else m[2]++;
            }
            
            // 곡괭이 수만큼 그룹 추가
            pq.add(m);
            if(pq.size() == total) break;
        }
        
        // 꺼내면서 계산
        int answer = 0;
        
        for(int i = 0; i < 3; i++) {
            while(picks[i]-- > 0 && !pq.isEmpty()) {
                int[] m = pq.poll();
                
                if(i == 0) answer += m[0] + m[1] + m[2];
                else if(i == 1) answer += 5 * m[0] + m[1] + m[2];
                else answer += 25 * m[0] + 5 * m[1] + m[2];
            }
        }
        
        return answer;
    }
}