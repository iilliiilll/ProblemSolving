class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        String dot = "";
        String x = "";
        String s;
        
        for(int i = 0; i < k; i++) {
            dot += ".";
            x += "x";
        }
        
        for(int i = 0, j = 0; i < picture.length; i++) {
            s = picture[i].replace(".", dot);
            s = s.replace("x", x);
            
            for(int a = 0; a < k; a++) {
                answer[j++] = s;
            }
        }
        
        return answer;
    }
}