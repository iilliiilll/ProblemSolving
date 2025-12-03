import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int len = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = 0;
        int b = 0;
        
        while(a < len && b < len) {
            if(A[a] < B[b]) a++;

            b++;
        }
        
        return a;
    }
}