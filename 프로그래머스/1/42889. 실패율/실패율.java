import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int user = stages.length;
        
        Map<Integer, Double> hm = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            double dA = hm.get(a);
            double dB = hm.get(b);
            
            if(dA == dB) {
                return a - b;
            }
            
            return Double.compare(dB, dA);
        });
        
        int idx = 0;
        int cnt = 0;
        
        Arrays.sort(stages);
        
        for(int i = 1; i <= N; i++) {
            cnt = 0;
            
            for(int j = idx; j < stages.length; j++) {
                if(stages[j] == i) {
                    cnt++;
                }
            }
            
            if(user == 0) {
                hm.put(i, (double) 0);
            } else {
                hm.put(i, (double) cnt / user);
            }
            
            pq.add(i);
            
            user -= cnt;
            idx += cnt;
        }
        
        for(int i = 0; i < N; i++) {
            answer[i] = pq.poll();
        }
        
        return answer;
    }
}