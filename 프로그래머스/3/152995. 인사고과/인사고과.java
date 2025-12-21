import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] my = scores[0];
        int sum = my[0] + my[1];
        int maxSecond = 0;
        int rank = 1;
        
        // 정렬. [0] 내림차순, [1] 오름차순
        Arrays.sort(scores, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(b[0], a[0]);
            return Integer.compare(a[1], b[1]);
        });
        
        for(int[] s : scores) {
            // 탈락. 현재[0]이 앞[0]보다 작거나 같음 + 현재[1]이 최대[1]보다 작음 -> 현재가 앞보다 작음
            if (s[1] < maxSecond) {
                if (s == my) return -1;
                continue;
            }
            
            maxSecond = Math.max(maxSecond, s[1]);
            
            // 등수
            if (s[0] + s[1] > sum) rank++;
        }
        
        return rank;
    }
}