import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        // k진수 변환 후 0으로 나누기
        String str = Integer.toString(n, k);
        StringTokenizer st = new StringTokenizer(str, "0");
        
        // 소수 판별
        while(st.hasMoreTokens()) {
            long num = Long.parseLong(st.nextToken());
            
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static boolean isPrime(long n) {
        if(n == 1) {
            return false;
        }
        
        for(long i = 2; i * i <= n ;i++) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}