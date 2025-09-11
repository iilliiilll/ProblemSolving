import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        List<Integer> ar = new ArrayList<>();
        
        for(int move : moves) {
            for(int[] b : board) {
                if(b[move - 1] != 0) {
                    ar.add(b[move - 1]);
                    b[move - 1] = 0;
                    break;
                }
            }
            
            if(ar.size() >= 2 && ar.get(ar.size() - 1) == ar.get(ar.size() - 2)) {
                ar.remove(ar.size() - 1);
                ar.remove(ar.size() - 1);
                answer += 2;
            }
        }
        
        return answer;
    }
}