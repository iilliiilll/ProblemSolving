import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i : arr) {
            int size = list.size();
            
            if(size == 0) {
                list.add(i);
            } else if(list.get(size - 1) == i) {
                list.remove(size - 1);
            } else {
                list.add(i);
            }
        }
        
        int[] answer;
        
        if(list.size() == 0) {
            answer = new int[] {-1};
        } else {
            answer = new int[list.size()];
            
            for(int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }
        
        return answer;
    }
}