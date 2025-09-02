import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] cnt = new int[3];
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i = 0; i < answers.length; i++) {
            if(arr1[i % arr1.length] == answers[i]) {
                cnt[0]++;
            }
            
            if(arr2[i % arr2.length] == answers[i]) {
                cnt[1]++;
            }
            
            if(arr3[i % arr3.length] == answers[i]) {
                cnt[2]++;
            }
        }
        
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] == max) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}