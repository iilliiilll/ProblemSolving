class Solution {
    public boolean solution(int x) {
        char[] ch_arr = String.valueOf(x).toCharArray();
        int sum = 0;
        
        for(char ch : ch_arr) {
            sum += (ch - '0');
        }
        
        return x % sum == 0;
    }
}