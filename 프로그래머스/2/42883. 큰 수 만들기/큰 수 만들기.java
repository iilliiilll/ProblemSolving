import java.util.*;

class Solution {
    public String solution(String number, int k) {
//         StringBuilder sb = new StringBuilder(number);
        
//         for (int i = 0; i + 1 < sb.length() && k > 0; i++) {
//             if(sb.charAt(i) < sb.charAt(i + 1)) {
//                 sb.deleteCharAt(i);
//                 i = -1;
//                 k--;
//             }
//         }
        
//         if(k != 0)
//             sb.delete(sb.length() - k, sb.length());
        
//         return sb.toString();
        
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
            
            if(sb.length() + k == number.length()) break;
        }
        
        return sb.toString();
    }
}