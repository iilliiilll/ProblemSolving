import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> hs = new HashSet<>();
        
        hs.add(words[0]);
        
        for(int i = 1; i < words.length; i++) {
            char last = words[i - 1].charAt(words[i - 1].length() - 1);
            char first = words[i].charAt(0);
            
            if(last != first || hs.contains(words[i])) {
                return new int[] {i % n + 1, i / n + 1};
            }
            
            hs.add(words[i]);
        }
        
        return new int[] {0, 0};
    }
}