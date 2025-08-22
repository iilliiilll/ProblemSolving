class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        char[] ch_arr = my_string.toCharArray();
        
        for(int i = 0; i < ch_arr.length; i++) {
            // if(Character.isLowerCase(ch_arr[i])) {
            //     sb.append(Character.toUpperCase(ch_arr[i]));
            // } else {
            //     sb.append(Character.toLowerCase(ch_arr[i]));
            // }
            
            if('a' <= ch_arr[i] && ch_arr[i] <= 'z') {
                sb.append("" + (char) (ch_arr[i] - 32));
            } else {
                sb.append("" + (char) (ch_arr[i] + 32));
            }
        }
        
        return sb.toString();
    }
}