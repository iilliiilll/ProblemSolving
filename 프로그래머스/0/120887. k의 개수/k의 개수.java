class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(int num = i; num <= j; num++) {
            char[] ch_arr = ("" + num).toCharArray();
            
            for(char ch : ch_arr) {
                if(ch - '0' == k) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}