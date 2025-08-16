import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        List<String> list = new ArrayList<>();
        
        String s = "";
        
        for(int i = 0; i < myStr.length(); i++) {
            char ch = myStr.charAt(i);
            
            if(ch == 'a' || ch == 'b' || ch == 'c') {
                if(!s.equals("")) {
                    list.add(s);
                    s = "";
                }
            } else {
                s += ch;
            }
        }
        
        if(!s.equals("")) {
            list.add(s);
            s = "";
        }
        
        if(list.size() == 0) {
            list.add("EMPTY");
        }
        
        return list.toArray(new String[0]);
    }
}