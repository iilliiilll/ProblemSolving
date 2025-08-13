import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int count = 0;
        
        for(boolean b : finished) {
            if(!b) {
                count++;
            }
        }
        
        String[] answer = new String[count];
        
        for(int i = 0, idx = 0; i < finished.length; i++) {
            if(!finished[i]) {
                answer[idx++] = todo_list[i];
            }
        }
        
        return answer;
    }
}