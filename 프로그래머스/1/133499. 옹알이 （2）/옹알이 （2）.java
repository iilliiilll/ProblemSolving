class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String b : babbling) {
            if(b.contains("ayaaya") || b.contains("yeye") || 
              b.contains("woowoo") || b.contains("mama")) {
                continue;
            } else {
                answer += b.replace("aya", " ").replace("ye", " ")
                    .replace("woo", " ").replace("ma", " ")
                    .replace(" ", "").length() == 0 ? 1 : 0;
            }
        }
        
        return answer;
    }
}