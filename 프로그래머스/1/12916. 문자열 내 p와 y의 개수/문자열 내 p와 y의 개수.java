class Solution {
    boolean solution(String s) {
        int cnt = 0;
        char[] ch_arr = String.valueOf(s).toCharArray();
        
        for(char ch : ch_arr) {
            if(ch == 'p' || ch == 'P') {
                cnt++;
            } else if(ch == 'y' || ch == 'Y') {
                cnt--;
            }
        }

        return cnt == 0 ? true : false;
    }
}