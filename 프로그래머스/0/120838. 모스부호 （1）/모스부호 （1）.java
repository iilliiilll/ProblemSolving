import java.util.*;

class Solution {
    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(letter);
        
        while(st.hasMoreTokens()) {
            switch(st.nextToken()) {
                case ".-" : sb.append("a"); break;
                case "-..." : sb.append("b"); break;
                case "-.-." : sb.append("c"); break;
                case "-.." : sb.append("d"); break;
                case "." : sb.append("e"); break;
                case "..-." : sb.append("f"); break;
                case "--." : sb.append("g"); break;
                case "...." : sb.append("h"); break;
                case ".." : sb.append("i"); break;
                case ".---" : sb.append("j"); break;
                case "-.-" : sb.append("k"); break;
                case ".-.." : sb.append("l"); break;
                case "--" : sb.append("m"); break;
                case "-." : sb.append("n"); break;
                case "---" : sb.append("o"); break;
                case ".--." : sb.append("p"); break;
                case "--.-" : sb.append("q"); break;
                case ".-." : sb.append("r"); break;
                case "..." : sb.append("s"); break;
                case "-" : sb.append("t"); break;
                case "..-" : sb.append("u"); break;
                case "...-" : sb.append("v"); break;
                case ".--" : sb.append("w"); break;
                case "-..-" : sb.append("x"); break;
                case "-.--" : sb.append("y"); break;
                case "--.." : sb.append("z"); break;
            }
        }
        
        return sb.toString();
    }
}