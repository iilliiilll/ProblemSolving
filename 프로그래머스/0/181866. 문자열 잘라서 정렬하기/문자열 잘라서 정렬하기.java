import java.util.*;

class Solution {
    public String[] solution(String myString) {
        List<String> list = new ArrayList<>();
        
        String[] answer = myString.split("x");
        
        for(String s : answer) {
            if(!s.equals("")) {
                list.add(s.trim());
            }
        }
        
        String[] str_arr = new String[list.size()];
        str_arr = list.toArray(new String[0]);
        
        Arrays.sort(str_arr);
        
        return str_arr;
    }
}