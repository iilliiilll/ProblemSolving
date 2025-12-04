import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> {
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        int answer = 1;
        int out = routes[0][1];
        
        for(int i = 1; i < routes.length; i++) {
            if (routes[i][0] > out) {
                out = routes[i][1];
                answer++;
            }
        }
         
        return answer;
    }
}