class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        
        char[] ch_arr = String.valueOf(age).toCharArray();
        
        for(char ch : ch_arr) {
            int num = ch - '0';
            char c = (char) (num + 97);
            
            sb.append(c);
        }
        
        return sb.toString();
    }
}