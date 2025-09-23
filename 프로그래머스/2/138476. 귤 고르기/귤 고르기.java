import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> hm = new HashMap<>();
        
        for(int i : tangerine) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        
        int[] arr = new int[hm.size()];
        int idx = 0;
        
        for(int value : hm.values()) {
            arr[idx++] = value;
        }
        
        Arrays.sort(arr);
        
        int answer = 0;
        int sum = 0;
        
        for(int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i];
            answer++;
            
            if(sum >= k) {
                break;
            }
        }
        
        return answer;
    }
}