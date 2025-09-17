import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] reportCount = new int[id_list.length];
        int[][] arr = new int[id_list.length][id_list.length];
        
        Map<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            hm.put(id_list[i], i);
        }
        
        StringTokenizer st;
        for(String str : report) {
            st = new StringTokenizer(str);
            int from = hm.get(st.nextToken());
            int to = hm.get(st.nextToken());
            
            if(arr[from][to] == 0) {
                arr[from][to] = -1;
                reportCount[to]++;
            }
        }
        
        for(int i = 0; i < reportCount.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(reportCount[i] >= k && arr[j][i] == -1) {
                    arr[j][i] = 1;
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}