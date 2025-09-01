class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] str_arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < str_arr.length; i++) {
            s = s.replaceAll(str_arr[i], String.valueOf(i));
        }
        
        return Integer.parseInt(s);
    }
}