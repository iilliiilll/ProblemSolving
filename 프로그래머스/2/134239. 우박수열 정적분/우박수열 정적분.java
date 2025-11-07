import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        // 횟수 세기
        List<Integer> list = new ArrayList<>();
        list.add(k);
        int count = 1;
        
        while(k > 1) {
            if(k % 2 == 0) k /= 2;
            else k = 3 * k + 1;
            
            list.add(k);
            count++;
        }
        
        // 넓이 구하기
        double[] s = new double[count];
        for(int i = 0; i < count - 1; i++) {
            s[i] = ((double) list.get(i + 1) + list.get(i)) / 2;
        }
        
        // 범위 넓이 구하기
        double[] answer = new double[ranges.length];
        int idx = 0;
        for(int[] range : ranges) {
            int from = range[0];
            int to = count - 1 + range[1];
            
            if(from == to) answer[idx] = 0;
            else if(from > to) answer[idx] = -1;
            else for(int i = from; i < to; i++) answer[idx] += s[i];
            
            idx++;
        }
        
        return answer;
    }
}