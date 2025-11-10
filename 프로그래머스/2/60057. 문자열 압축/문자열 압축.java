import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length() / 2; i++) answer = Math.min(answer, getLen(s, i));
        
        return answer;
    }
    
    private static int getLen(String s, int divide) {
        StringBuilder sb = new StringBuilder();
        
        // 배열 길이 구하기
        int len = 0;
        if(s.length() % divide == 0) len = s.length() / divide;
        else len = s.length() / divide + 1;
        
        // divide 만큼 나눠서 배열에 저장
        String[] arr = new String[len];
        for(int i = 0; i < len; i++) arr[i] = s.substring(i * divide, Math.min((i + 1) * divide, s.length()));
        
        // 같은 문자열의 개수 구하기
        String temp = arr[0];
        int count = 1;
        
        for(int i = 1; i < len; i++) {
            if(temp.equals(arr[i])) {
                count++;
            } else {
                if(count != 1) sb.append(count);
                sb.append(arr[i - 1]);
                
                temp = arr[i];
                count = 1;
            }
        }
        
        if(count != 1) sb.append(count);
        sb.append(arr[len - 1]);
        
        return sb.length();
    }
}