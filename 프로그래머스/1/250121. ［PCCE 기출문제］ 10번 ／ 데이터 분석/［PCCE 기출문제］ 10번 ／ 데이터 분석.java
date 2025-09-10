import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        Queue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            int n = getNum(sort_by);
            return Integer.compare(a[n], b[n]);
        });
        
        int num = getNum(ext);
        for(int[] dt : data) {
            if(dt[num] < val_ext) {
                pq.add(dt);
            }
        }
        
        while(!pq.isEmpty()) {
            list.add(pq.poll());
        }
        
        int[][] answer = new int[list.size()][4];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private static int getNum(String str) {
        int num = 0;
        
        if(str.equals("date")) {
            num = 1;
        } else if(str.equals("maximum")) {
            num = 2;
        } else if(str.equals("remain")) {
            num = 3;
        }
        
        return num;
    }
}