import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        // t * m까지 append 후, char[]로 변환
        int num = 0;
        while(sb.length() < t * m - 1) {
            sb.append(Integer.toString(num++, n));
        }
        char[] arr = sb.toString().toCharArray();
        
        // 인덱스 뽑아서 answer에 append
        while(answer.length() < t) {
            answer.append(arr[p - 1]);
            p += m;
        }
        
        return answer.toString().toUpperCase();
    }
}