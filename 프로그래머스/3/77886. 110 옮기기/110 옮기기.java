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
        
        // 0 바로 뒤에 추가. 없으면 맨 앞.
        int idx = sb.lastIndexOf("0");
        sb.insert(idx + 1, "110".repeat(count));

        return sb.toString();
    }
}