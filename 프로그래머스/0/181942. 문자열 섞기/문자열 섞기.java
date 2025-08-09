class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        
        for(int i = 0; i < s1.length; i++) {
            sb.append(s1[i]).append(s2[i]);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}