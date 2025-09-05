class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] str = {"aya", "ye", "woo", "ma"};
        String prefix = "?";
        boolean flag = false;
        
        for(String b : babbling) {
            while(true) {
                if(b.startsWith(prefix)) {
                    flag = false;
                    break;
                }
                
                for(String s : str) {
                    if(b.startsWith(s)) {
                        prefix = s;
                        b = b.replaceFirst(s, "");
                        System.out.println(b);
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
                
                if(!flag) {
                    break;
                }
                
                if(b.isEmpty()) {
                    flag = true;
                    break;
                }
            }
            
            if(flag) {
                answer++;
            }
            
            prefix = "?";
        }
        
        return answer;
    }
}