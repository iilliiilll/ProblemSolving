class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        
        int mode = 0;
        
        for(int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            
            if (ch == '1') {
                mode = (mode + 1) % 2;
                continue;
            }
            
            if (i % 2 == mode) {
                sb.append(ch);
            }
        }
        
        return sb.length() == 0 ? "EMPTY" : sb.toString();
    }
}