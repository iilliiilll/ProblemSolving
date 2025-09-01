class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        
        for(char ch : s.toCharArray()) {
            if(ch == ' ') {
                sb.append(ch);
            } else {
                int gap;

                gap = ch == Character.toUpperCase(ch) ? (int) (ch - 'A') : (int) (ch - 'a');

                sb.append(gap + n > 25 ? (char) (ch + n - 26) : (char) (ch + n));
            }
        }
        
        return sb.toString();
    }
}