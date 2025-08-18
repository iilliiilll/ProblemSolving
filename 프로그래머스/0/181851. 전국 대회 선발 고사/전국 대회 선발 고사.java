import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < attendance.length; i++) {
            if(attendance[i]) {
                list.add(rank[i]);
            }
        }
        
        int[] arr = new int[list.size()];
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        
        Arrays.sort(arr);
        
        int answer = 0;
        
        for(int i = 0, k = 2; i < 3; i++) {
            for(int j = 0; j < rank.length; j++) {
                if(arr[i] == rank[j]) {
                    answer += j * (int) Math.pow(100, k--);
                    break;
                }
            }
        }
        
        return answer;
    }
}