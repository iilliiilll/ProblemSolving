import java.util.*;

class Solution {
    static boolean[] visited = new boolean[8];
    static char[] kakao = new char[] {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int answer = 0;
    
    public int solution(int n, String[] data) {
        // 모든 경우의 수 만들면서 가지치기
        answer = 0;
        dfs(0, "", data);
        return answer;
    }
    
    private static void dfs(int count, String str, String[] data) {
        if(count == 8) {
            if(isGood(str, data)) {
                answer++;
            }
            
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(count + 1, str + kakao[i], data);
                visited[i] = false;
            }
        }
    }
    
    // str이 조건에 맞는지?
    private static boolean isGood(String str, String[] data) {
        for(String d : data) {
            char ch1 = d.charAt(0);
            char ch2 = d.charAt(2);
            char compare = d.charAt(3);
            int dist = d.charAt(4) - '0';
            
            int start = str.indexOf(ch1);
            int end = str.indexOf(ch2);
            int diff = Math.abs(end - start) - 1;
            
            if(compare == '>') {
                if(diff <= dist) {
                    return false;
                }
            } else if(compare == '<') {
                if(diff >= dist) {
                    return false;
                }
            } else {
                if(diff != dist) {
                    return false;
                }
            }
        }
        
        return true;
    }
}