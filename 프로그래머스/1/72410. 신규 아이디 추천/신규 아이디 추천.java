class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        char[] ch_arr = new_id.toCharArray();
        
        for(int i = 0; i < ch_arr.length; i++) {
            if(Character.isLetter(ch_arr[i])) {
                sb.append(Character.toLowerCase(ch_arr[i]));
            } else if(Character.isDigit(ch_arr[i]) || 
                      ch_arr[i] == '-' || ch_arr[i] == '_' || ch_arr[i] == '.') {
                if(i > 1 && ch_arr[i] == '.' && ch_arr[i-1] == '.') {
                    continue;
                } else {
                    sb.append(ch_arr[i]);
                }
            }
        }
        
        String str = sb.toString();
        
        while(true) {
            if(str.contains("..")) {
                str = str.replace("..", ".");
            } else {
                break;
            }
        }
        
        sb = new StringBuilder(str);
        
        if(sb.length() > 0 && sb.charAt(0) == '.') {
            System.out.println("sb : " + sb.toString());
            sb.deleteCharAt(0);
            System.out.println("sb : " + sb.toString());
        }
        if(sb.length() > 1 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(sb.length() == 0) {
            sb.append('a');
        } else if(sb.length() >= 16) {
            sb.delete(15, sb.length());
            
            if(sb.charAt(sb.length() - 1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
        if(sb.length() <= 2) {
            while(sb.length() < 3) {
                sb.append(sb.charAt(sb.length() - 1));
            }
        }
        
        return sb.toString();
    }
}