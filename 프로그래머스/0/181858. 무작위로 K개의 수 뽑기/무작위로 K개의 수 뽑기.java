import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        
        for(int i = 0; i < k; i++) {
            answer[i] = -1;
        }
        
        for(int i = 0, a = 0; i < arr.length; i++) {
            boolean b = true;
            
            for(int j = 0; j < a; j++) {
                if(arr[i] == answer[j]) {
                    b = false;
                    break;
                }
            }
            
            if(b) {
                answer[a++] = arr[i];
            }
            
            if(a == k) {
                break;
            }
        }
        
        return answer;
    }
}