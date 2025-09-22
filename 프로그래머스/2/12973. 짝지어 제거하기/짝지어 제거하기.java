import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> ad = new ArrayDeque<>();
        
        for(char ch : s.toCharArray()) {
            if(ad.size() > 0) {
                if(ad.peekLast() == ch) {
                    ad.pollLast();
                } else {
                    ad.addLast(ch);
                }
            } else {
                ad.addLast(ch);
            }
        }
        
        return ad.size() == 0 ? 1 : 0;
    }
}