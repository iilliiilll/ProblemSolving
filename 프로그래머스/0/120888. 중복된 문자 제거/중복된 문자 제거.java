class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        char[] ch_arr = my_string.toCharArray();
        answer += ch_arr[0];
        
        for(int i = 1; i < ch_arr.length; i++) {
            if(!answer.contains(("" + ch_arr[i]))) {
                answer += ("" + ch_arr[i]);
            }
        }
        
        return answer;
    }
}