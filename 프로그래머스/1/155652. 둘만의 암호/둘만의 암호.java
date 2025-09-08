class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        char[] alpha = new char[26];
        for(int i = 0; i < 26; i++) {
            alpha[i] = (char) ('a' + i);
        }
        
        for(char ch : skip.toCharArray()) {
            alpha[(int) (ch - 'a')] = ' ';
        }
        
        for(char ch : s.toCharArray()) {
            char c = '-';
            int tmp = index;
            
            for(int i = 1; i <= tmp; i++) {
                if(alpha[(int) (ch - 'a' + i) % 26] == ' ') {
                    tmp++;
                } else {
                    c = alpha[(int) (ch - 'a' + i) % 26];
                }
            }
            
            sb.append(c);
        }
        
        return sb.toString();
    }
}