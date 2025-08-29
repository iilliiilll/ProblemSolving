class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        
        int len = phone_number.length();
        
        sb.append("*".repeat(len - 4));
        sb.append(phone_number.substring(len - 4));
        
        return sb.toString();
    }
}