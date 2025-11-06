import java.util.*;

class Solution {
    static List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        move(1, 2, 3, n - 1);
        move(1, 3, 2, 1);
        move(2, 3, 1, n - 1);
        
        // return
        int[][] answer = new int[list.size()][2];
        for(int i = 0; i < answer.length; i++) answer[i] = list.get(i);
        return answer;
    }
    
    private static void move(int from, int to, int rest, int n) {
        if(n == 1) {
            list.add(new int[] {from, to});
            return;
        }
        
        move(from, rest, to, n - 1);
        move(from, to, rest, 1);
        move(rest, to, from, n - 1);
    }
}