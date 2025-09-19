import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        StringTokenizer st;
        Map<String, Integer> name = new HashMap<>();
        Map<String, Integer> point = new HashMap<>();
        int[][] arr = new int[friends.length][friends.length];
        
        for(int i = 0; i < friends.length; i++) {
            name.put(friends[i], i);
            point.put(friends[i], 0);
        }
        
        for(String gift : gifts) {
            st = new StringTokenizer(gift);
            String give = st.nextToken();
            String take = st.nextToken();
            
            // 주고받은 선물
            arr[name.get(give)][name.get(take)]++;
            
            // 선물 지수
            point.put(give, point.getOrDefault(give, 0) + 1);
            point.put(take, point.getOrDefault(take, 0) - 1);
        }
        
        int max = 0;
        
        for(int i = 0; i < friends.length; i++) {
            int cnt = 0;
            
            for(int j = 0; j < friends.length; j++) {
                if(i == j) {
                    continue;
                }
                
                if(arr[i][j] > arr[j][i]) {
                    cnt++;
                } else if(arr[i][j] == arr[j][i] && point.get(friends[i]) > point.get(friends[j])) {
                    cnt++;
                }
            }
            
            max = Math.max(max, cnt);
        }
        
        return max;
    }
}