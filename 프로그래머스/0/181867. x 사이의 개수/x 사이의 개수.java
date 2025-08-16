import java.util.*;

class Solution {
    public int[] solution(String myString) {
        List<Integer> list = new ArrayList<>();
        
        String[] str_arr = myString.split("x", -1);
        
        for(String s : str_arr) {
            list.add(s.length());
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}