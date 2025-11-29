import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(str.equals("D")) { // 최댓값, 최솟값 삭제
                if(map.isEmpty()) continue;
                
                int key = num == 1 ? map.lastKey() : map.firstKey();
                int count = map.get(key);
                
                if(count == 1) map.remove(key);
                else map.put(key, count - 1);
            } else { // 숫자 삽입
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        
        if(map.isEmpty()) return new int[] {0, 0};
        
        return new int[] {map.lastKey(), map.firstKey()};
    }
}