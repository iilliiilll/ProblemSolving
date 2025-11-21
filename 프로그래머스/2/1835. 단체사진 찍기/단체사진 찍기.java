import java.util.*;

class Solution {
    static boolean[] visited = new boolean[8];
    static char[] kakao = new char[] {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int answer = 0;
    
    public int solution(int n, String[] data) {
        // 모든 경우의 수 만들면서 가지치기
        answer = 0;
        dfs("", data);
        return answer;
    }
    
    private static void dfs(String str, String[] data) {
        if(str.length() == 8) {
            boolean b = false;
            
            for(String d : data) {
                int diff = Math.abs(str.indexOf(d.charAt(2)) - str.indexOf(d.charAt(0))) - 1;

                if(d.charAt(3) == '>') {
                    if(diff <= d.charAt(4) - '0') {
                        b = false;
                        break;
                    }
                } else if(d.charAt(3) == '<') {
                    if(diff >= d.charAt(4) - '0') {
                        b = false;
                        break;
                    }
                } else {
                    if(diff != d.charAt(4) - '0') {
                        b = false;
                        break;
                    }
                }
                
                b = true;
            }
            
            if(b) answer++;
            
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(str + kakao[i], data);
                visited[i] = false;
            }
        }
    }
}