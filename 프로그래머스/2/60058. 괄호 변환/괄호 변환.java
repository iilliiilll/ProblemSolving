import java.util.*;

class Solution {
    public String solution(String p) {
        return get(p);
    }
    
    private static String get(String w) {
        // 1. 빈 문자열이면 반환
        if(w.isEmpty()) return w;
        
        // 2. u, v로 분리
        char[] temp = w.toCharArray();
        int tempNum = 0;
        int i;
        
        for(i = 0; i < temp.length; i++) {
            if(temp[i] == '(') tempNum++;
            else tempNum--;
            
            if(tempNum == 0) break;
        }
        
        String u = w.substring(0, i + 1);
        String v = w.substring(i + 1, w.length());
        
        // 3, 4. u가 올바른 괄호 문자열인지
        StringBuilder sb = new StringBuilder();
        
        if(good(u)) return sb.append(u).append(get(v)).toString();
        else return sb.append("(").append(get(v)).append(")").append(reverse(u)).toString();
        
    }
    
    // 올바른 문자열?
    private static boolean good(String u) {
        Deque<Character> deque = new ArrayDeque<>();
        
        for(int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);
            
            if(c == '(') {
                deque.addLast(c);
            } else {
                if(deque.isEmpty()) return false;
                else deque.removeLast();
            }
        }
        
        if(deque.isEmpty()) return true;
        return false;
    }
    
    // 4-4
    private static String reverse(String u) {
        if(u.isEmpty()) return u;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < u.length() - 1; i++) {
            if(u.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }
}