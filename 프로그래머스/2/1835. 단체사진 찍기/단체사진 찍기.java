import java.util.*;

class Solution {
    static char[] kakao = new char[] {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[] result = new char[8];
    static boolean[] visited = new boolean[8];
    static int answer = 0;
    
    public int solution(int n, String[] data) {
        // 모든 경우의 수 만들면서 가지치기
        answer = 0;
        dfs(0, data);
        return answer;
    }
    
    private static void dfs(int count, String[] data) {
        if(count == 8) {
            // str 만들기
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 8; i++) {
                sb.append(result[i]);
            }
            String str = sb.toString();
            
            boolean b = false;
            for(String d : data) {
                int diff = Math.abs(str.indexOf(d.charAt(2)) - str.indexOf(d.charAt(0))) - 1;
                int dist = d.charAt(4) - '0';

                if(d.charAt(3) == '>') {
                    if(diff <= dist) {
                        b = false;
                        break;
                    }
                } else if(d.charAt(3) == '<') {
                    if(diff >= dist) {
                        b = false;
                        break;
                    }
                } else {
                    if(diff != dist) {
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
                result[count] = kakao[i];
                dfs(count + 1, data);
                visited[i] = false;
            }
        }
    }
}