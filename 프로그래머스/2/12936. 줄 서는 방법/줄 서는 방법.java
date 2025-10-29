import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        
        long total = 1;
        for(int i = 1; i <= n; i++) {
            list.add(i);
            total *= i;
        }
        
        k--;
        int idx = 0;
        
        while(idx < n) {
            // block size
            total /= n - idx; 
            
            // 현재 자리 선택
            int value = (int) (k / total);
            answer[idx++] = list.remove(value);
            
            // 다음 블록으로
            k %= total;
        }
        
        return answer;
    }
}