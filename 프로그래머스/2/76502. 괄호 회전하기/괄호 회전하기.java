import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb;
        int answer = 0;
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < s.length(); i++) {
            sb = new StringBuilder();
            
            for(int j = i; j < i + s.length(); j++) {
                sb.append(arr[j % arr.length]);
            }
            
            if(isGood(sb.toString())) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static boolean isGood(String s) {
        Deque<Character> ad = new ArrayDeque<>();
        
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                ad.addLast(ch);
            } else if(ch == ')') {
                if(ad.size() > 0 && ad.getLast() == '(') {
                    ad.removeLast();
                } else {
                    return false;
                }
            } else if(ch == '}') {
                if(ad.size() > 0 && ad.getLast() == '{') {
                    ad.removeLast();
                } else {
                    return false;
                }
            } else if(ch == ']') {
                if(ad.size() > 0 && ad.getLast() == '[') {
                    ad.removeLast();
                } else {
                    return false;
                }
            }
        }
        
        return ad.isEmpty();
    }
}