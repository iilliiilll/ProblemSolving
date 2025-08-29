import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(arr);
        
        for(int i : arr) {
            if(i % divisor == 0) {
                list.add(i);
            }
        }
        
        if(list.size() == 0) {
            return new int[] { -1 };
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}