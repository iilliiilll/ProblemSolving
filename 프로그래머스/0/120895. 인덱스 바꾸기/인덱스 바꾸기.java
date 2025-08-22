class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] ch_arr = my_string.toCharArray();
        
        char ch = ch_arr[num1];
        ch_arr[num1] = ch_arr[num2];
        ch_arr[num2] = ch;
        
        return new String(ch_arr);
    }
}