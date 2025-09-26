import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) {
            return 5 * cities.length;
        }
        
        int time = 0;
        
        Deque<String> ad = new ArrayDeque<>();
        
        for(String city : cities) {
            city = city.toUpperCase();
            
            if(ad.contains(city)) { // 값이 있으면
                ad.remove(city);
                ad.addFirst(city);
                
                time += 1;
            } else { // 값이 없으면
                if(ad.size() < cacheSize) { // 넣을 수 있으면
                    ad.addFirst(city);
                } else { // 꽉 찼으면
                    ad.removeLast();
                    ad.addFirst(city);
                }
                
                time += 5;
            }
        }
        
        return time;
    }
}