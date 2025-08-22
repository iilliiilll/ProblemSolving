class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        
        char[] ch_arr = cipher.toCharArray();
        
        for(int i = code - 1; i < ch_arr.length; i += code) {
            sb.append(ch_arr[i]);
        }
        
        return sb.toString();
    }
}