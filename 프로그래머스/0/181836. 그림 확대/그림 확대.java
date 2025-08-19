class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        
        for(int i = 0, j = 0; i < picture.length; i++) {
            String s = picture[i].replace(".", ".".repeat(k)).replace("x", "x".repeat(k));
            
            for(int a = 0; a < k; a++) {
                answer[j++] = s;
            }
        }
        
        return answer;
    }
}