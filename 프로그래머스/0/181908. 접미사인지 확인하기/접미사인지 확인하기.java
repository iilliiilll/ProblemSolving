class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer;
        String[] str_arr = new String[my_string.length()];
        
        for(int i = 0; i < my_string.length(); i++) {
            str_arr[i] = my_string.substring(i);
        }
        
        for(String s : str_arr) {
            if(s.equals(is_suffix)) {
                return 1;
            } 
        }
        
        return 0;
    }
}