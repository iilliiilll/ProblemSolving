class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String temp = "";
        
        for(int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            
            if('0' <= ch && ch <= '9') {
                temp += String.valueOf(ch);
            } else if(!temp.isEmpty()) {
                answer += Integer.parseInt(temp);
                temp = "";
            }
        }
        
        if(!temp.isEmpty()) {
            answer += Integer.parseInt(temp);
        }
        
        return answer;
    }
}