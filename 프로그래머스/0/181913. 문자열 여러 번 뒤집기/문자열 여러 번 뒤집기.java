class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] ch_arr = my_string.toCharArray();
        
        for(int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            
            while(start < end) {
                char temp = ch_arr[start];
                ch_arr[start] = ch_arr[end];
                ch_arr[end] = temp;
                
                start++;
                end--;
            }
        }
        
        return new String(ch_arr);
        
    }
}