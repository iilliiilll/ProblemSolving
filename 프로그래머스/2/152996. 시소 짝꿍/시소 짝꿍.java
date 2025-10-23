import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        // map에 추가
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : weights) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        // 순회
        for(int i : map.keySet()) {
            int cnt = map.get(i);
            int findNum;
            
            // 1:1 -> 개수의 nC2 = n * (n - 1) / 2
            answer += (long) cnt * (cnt - 1) / 2;
            
            // 1:2 -> 1인 개수 * 2인 개수
            findNum = i * 2;
            answer += (long) (cnt) * (map.getOrDefault(findNum, 0));
            
            // 2:3
            if((i * 3) % 2 == 0) {
                findNum = i / 2 * 3;
                answer += (long) (cnt) * (map.getOrDefault(findNum, 0));
            }
            
            // 3:4
            if((i * 4) % 3 == 0) {
                findNum = i / 3 * 4;
                answer += (long) (cnt) * (map.getOrDefault(findNum, 0));
            }
        }
        
        return answer;
    }
}