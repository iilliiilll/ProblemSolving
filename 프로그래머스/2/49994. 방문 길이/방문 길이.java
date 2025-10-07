import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> hs = new HashSet<>();
        
        int x = 0;
        int y = 0;
        String prev = "00";
        
        for(char dir : dirs.toCharArray()) {
            if(dir == 'U') {
                if(y == 5) {
                    continue;
                }
                
                y++;
            } else if(dir == 'D') {
                if(y == -5) {
                    continue;
                }
                
                y--;
            } else if(dir == 'R') {
                if(x == 5) {
                    continue;
                }
                
                x++;
            } else{
                if(x == -5) {
                    continue;
                }
                
                x--;
            }
            
            hs.add(prev + String.valueOf(x) + String.valueOf(y));
            hs.add(String.valueOf(x) + String.valueOf(y) + prev);
            prev = String.valueOf(x) + String.valueOf(y);
        }
        
        return hs.size() / 2;
    }
}