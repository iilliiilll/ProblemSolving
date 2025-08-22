import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        int[] arr = new int[score.length];
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] = score[i][0] + score[i][1];
        }
        
        for(int i = 0; i < arr.length; i++) {
            int cnt = 0;
            
            for(int j = 0; j < arr.length; j++) {
                if(j != i && arr[j] > arr[i]) {
                    cnt++;
                }
            }
            
            answer[i] = 1 + cnt;
        }
        
        return answer;
    }
}