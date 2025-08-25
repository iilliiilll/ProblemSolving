import java.util.*;

class Solution {
    public String solution(String polynomial) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(polynomial, " +");
        
        int xCnt = 0;
        int nCnt = 0;
        
        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            
            if(str.contains("x")) {
                if(str.length() == 1) {
                    xCnt += 1;
                } else {
                    String s = str.substring(0, str.length() - 1);
                    xCnt += Integer.parseInt(s);
                }
            } else {
                nCnt += Integer.parseInt(str);
            }
        }
        
        if(xCnt == 0) {
            sb.append(nCnt);
        } else if(xCnt == 1) {
            if(nCnt == 0) {   
                sb.append("x");
            } else {
                sb.append("x").append(" + ").append(nCnt);
            }
        } else {        
            if(nCnt == 0) {
                sb.append(xCnt).append("x");
            } else {
                sb.append(xCnt).append("x").append(" + ").append(nCnt);
            }
        }
        
        return sb.toString();
    }
}