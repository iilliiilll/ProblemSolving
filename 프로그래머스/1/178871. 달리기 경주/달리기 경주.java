import java.util.*;

class Solution {
    static Map<String, Integer> hm = new HashMap<>();
    
    public String[] solution(String[] players, String[] callings) {
        // HashMap 추가
        for(int i = 0; i < players.length; i++) {
            hm.put(players[i], i);
        }
        
        // 호명
        for(String calling : callings) {
            // calling 등수
            int idx = hm.get(calling);
            
            // calling 앞의 선수 이름
            String name = players[idx - 1];
            
            // players, hm 업데이트
            players[idx - 1] = calling;
            players[idx] = name;
            
            hm.put(calling, idx - 1);
            hm.put(name, idx);
        }
        
        return players;
    }
}