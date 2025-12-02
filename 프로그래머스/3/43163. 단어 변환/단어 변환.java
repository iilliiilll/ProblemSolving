import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // target 존재 여부
        if(!isExist(target, words)) return 0;
        
        // 알파벳 하나만 변경 가능하면 q에 추가
        boolean[] visited = new boolean[words.length];
        
        Queue<String> q = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        q.add(begin);
        d.add(0);
        
        while(!q.isEmpty()) {
            String str = q.poll();
            int depth = d.poll();
            
            if(str.equals(target)) return depth;
            
            for(int i = 0; i < visited.length; i++) {
                if(!visited[i] && diff(words[i], str) == 1) {
                    visited[i] = true;
                    q.add(words[i]);
                    d.add(depth + 1);
                }
            }
        }
        
        return 0;
    }
    
    private static int diff(String before, String after) {
        int count = 0;
        
        char[] ch1 = before.toCharArray();
        char[] ch2 = after.toCharArray();
        
        for(int i = 0; i < before.length(); i++) {
            if(ch1[i] != ch2[i]) count++;
            if(count > 1) return count;
        }
        
        return count;
    }
    
    private static boolean isExist(String target, String[] words) {
        for(String word : words) {
            if(word.equals(target)) return true;
        }
        
        return false;
    }
}