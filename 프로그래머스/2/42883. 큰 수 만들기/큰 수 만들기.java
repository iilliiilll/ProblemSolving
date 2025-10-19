import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        int temp = k;
        
        for(char c : number.toCharArray()) {
            while(temp > 0 && !deque.isEmpty() && deque.getLast() < c) {
                deque.removeLast();
                temp--;
            }
            
            deque.addLast(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!deque.isEmpty()) {
            sb.append(deque.removeFirst());
            
            if(sb.length() + k == number.length()) {
                break;
            }
        }
        
        return sb.toString();
    }
}