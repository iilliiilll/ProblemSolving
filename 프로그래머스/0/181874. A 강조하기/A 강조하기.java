class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < myString.length(); i++) {
            char ch = myString.charAt(i);
            
            if(ch == 'a' || ch == 'A') {
                sb.append("A");
            } else {
                sb.append(Character.toLowerCase(ch));
            }
        }
        
        return sb.toString();
    }
}