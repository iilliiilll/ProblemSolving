import java.util.*;

class Solution {
    // <좌표압축, <시간, 지나간 횟수>>
    static Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    
    public int solution(int[][] points, int[][] routes) {
        for(int[] route : routes) {
            int second = 0;
            
            int idx = route[0];
            int r = points[idx - 1][0];
            int c = points[idx - 1][1];
            int temp = r * 10000 + c;
            
            useMap(temp, second++);
            
            for(int i = 0; i < route.length - 1; i++) {
                // 현재 위치
                idx = route[i];
                r = points[idx - 1][0];
                c = points[idx - 1][1];
                
                // 다음 위치로 넘어가기
                int nextIdx = route[i + 1];
                int nextR = points[nextIdx - 1][0];
                int nextC = points[nextIdx - 1][1];
                
                // r부터 이동
                while(r != nextR) {
                    if(r > nextR) temp = --r * 10000 + c;
                    else if(r < nextR) temp = ++r * 10000 + c;
                    
                    useMap(temp, second++);
                }
                
                // c 이동
                while(c != nextC) {
                    if(c > nextC) temp = r * 10000 + --c;
                    else if(c < nextC) temp = r * 10000 + ++c;
                    
                    useMap(temp, second++);
                }
            }
        }
        
        // map 순회
        int answer = 0;
        
        for(Map<Integer, Integer> mmap : map.values()) {
            for(int count : mmap.values()) {
                if(count > 1) answer++;
            }
        }
        
        return answer;
    }
    
    private static void useMap(int temp, int second) {
        map.computeIfAbsent(temp, k -> new HashMap<>());
        Map<Integer, Integer> mmap = map.get(temp);
        mmap.put(second, mmap.getOrDefault(second, 0) + 1);
    }
}