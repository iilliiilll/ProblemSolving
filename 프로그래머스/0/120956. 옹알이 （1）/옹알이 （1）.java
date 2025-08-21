class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] speak = {"aya", "ye", "woo", "ma"};
        
        for(String b : babbling) {
            int bLen = b.length();
            int sLen = 0;
            
            for(String s : speak) {
                if(b.contains(s)) {
                    sLen += s.length();
                }
                
                if(bLen == sLen) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}