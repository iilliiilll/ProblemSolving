import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        int num = 2;
        while(n != 1) {
            if(n % num == 0) {
                list.add(num);
                
                while(n % num == 0) {
                    n /= num;
                }
            }
            
            num++;
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}