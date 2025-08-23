class Solution {
    public int solution(String[] spell, String[] dic) {
        boolean chk = false;
        
        for(String d : dic) {
            if(d.length() == spell.length) {
                for(String s : spell) {
                    if(d.contains(s)) {
                        chk = true;
                    } else {
                        chk = false;
                        break;
                    }
                }
                
                if(chk) {
                    return 1;
                }
            }
        }
        
        return 2;
    }
}