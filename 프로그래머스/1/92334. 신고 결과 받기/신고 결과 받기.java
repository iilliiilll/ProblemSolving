import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> idMap = new HashMap<>();
        Map<String, Set<String>> reportMap = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++) {
            idMap.put(id_list[i], i);
            reportMap.put(id_list[i], new HashSet<>());
        }
        
        StringTokenizer st;
        for(String r : report) {
            st = new StringTokenizer(r);
            String from = st.nextToken();
            String to = st.nextToken();
            
            if(!reportMap.get(to).contains(from)) {
                reportMap.get(to).add(from);
            }
        }
        
        int[] answer = new int[id_list.length];
        for(String id : id_list) {
            if(k <= reportMap.get(id).size()) {
                for(String r : reportMap.get(id)) {
                    answer[idMap.get(r)]++;
                }
            }
        }
        
        return answer;
    }
}