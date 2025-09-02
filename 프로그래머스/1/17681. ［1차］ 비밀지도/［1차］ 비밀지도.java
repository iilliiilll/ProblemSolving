class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb;
        
        for(int i = 0; i < n; i++) {
            sb = new StringBuilder();
            
            String str = Integer.toString(arr1[i] | arr2[i], 2);
            char[] ch_arr = str.toCharArray();
            
            sb.append(" ".repeat(n - ch_arr.length));
            
            for(char ch : ch_arr) {
                sb.append(ch == '1' ? '#' : ' ');
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}