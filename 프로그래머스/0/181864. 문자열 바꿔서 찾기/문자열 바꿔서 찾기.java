class Solution {
    public int solution(String myString, String pat) {
        char[] ch_arr = pat.toCharArray();
        
        for(int i = 0; i < ch_arr.length; i++) {
            ch_arr[i] = ch_arr[i] == 'A' ? 'B' : 'A';
        }
        
        return myString.contains(new String(ch_arr)) ? 1 : 0;
    }
}