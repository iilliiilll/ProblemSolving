import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        for (int i = 0; i < s.length; i++) s[i] = getAnswer(s[i]);
        return s;
    }
    
    private static String getAnswer(String before) {
        // 110 개수 세기
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < before.length(); i++) {
            sb.append(before.charAt(i));
            int len = sb.length();
            
            if (len >= 3 && sb.charAt(len - 3) == '1' && sb.charAt(len - 2) == '1' && sb.charAt(len - 1) == '0') {
                sb.delete(len - 3, len);
                count++;
            }
        }

        before = sb.toString();
        String addStr = "110".repeat(count);
        
        // 110 삽입 (마지막 0 뒤)
        if (before.contains("0")) {
            int idx = before.lastIndexOf("0");
            before = before.substring(0, idx + 1) + addStr + before.substring(idx + 1, before.length());
        } else {
            before = addStr + before;
        }
        
        return before;
    }
}