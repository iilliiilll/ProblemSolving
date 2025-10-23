import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int n = book_time.length;
        int[][] times = new int[n][2];
        
        // String -> int 변환
        for(int i = 0; i < n; i++) {
            times[i][0] = toMin(book_time[i][0]);
            times[i][1] = toMin(book_time[i][1]) + 10;
        }
        
        // 시작시각 기준 정렬
        Arrays.sort(times, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        
        // 우선순위 큐
        Queue<Integer> pq = new PriorityQueue<>();
        
        for(int[] time : times) {
            // 앞 방의 퇴실 시각 <= 현재 방의 입실 시각
            if(!pq.isEmpty() && pq.peek() <= time[0]) {
                pq.poll();
            }
            pq.add(time[1]);
        }
        
        return pq.size();
    }
    
    private static int toMin(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        return h * 60 + m;
    }
}