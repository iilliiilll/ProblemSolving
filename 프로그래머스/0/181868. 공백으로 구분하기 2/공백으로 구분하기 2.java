import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        StringTokenizer st = new StringTokenizer(my_string);
        
        List<String> list = new ArrayList<>();
        
        while(st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        
        return list.toArray(new String[0]);
    }
}