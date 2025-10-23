import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // 철수, 영희의 최대공약수 찾기
        int a = arrayA[0];
        int b = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++) {
            a = gcd(a, arrayA[i]);
            b = gcd(b, arrayB[i]);
        }

        // a가 영희의 모든 원소를 나눌 수 없어야 함
        int answer = 0;
        boolean bool = true;
        
        for(int i : arrayB) {
            if(i % a == 0) {
                bool = false;
                break;
            }
        }
        
        // 나눌 수 있다면
        if(bool) {
            answer = a;
        }
        
        // b가 철수의 모든 원소를 나눌 수 없어야 함
        bool = true;
        
        for(int i : arrayA) {
            if(i % b == 0) {
                bool = false;
                break;
            }
        }
        
        // 나눌 수 있다면
        if(bool) {
            answer = Math.max(answer, b);
        }
        
        
        return answer;
    }
    
    private static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}