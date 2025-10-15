import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // deque에 skill 넣기
        Deque<Character> deque = new ArrayDeque<>();
        for(char c : skill.toCharArray()) {
            deque.addLast(c);
        }
        
        // skill_trees 순회
        for(String skills : skill_trees) {
            Deque<Character> temp = new ArrayDeque<>(deque);
            boolean b = true;
            
            // s 순회. 포함x: continue. 포함o: deque.removeLast
            for(char c : skills.toCharArray()) {
                if(!temp.contains(c)) {
                    continue;
                } else {
                    if(temp.getFirst() == c) {
                        temp.removeFirst();
                    } else {
                        b = false;
                        break;
                    }
                }
            }
            
            if(b) {
                answer++;
            }
        }
        
        return answer;
    }
}