import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        
        // 특정 범위에서의 최솟값 구하기
        int[] left = new int[n];
        int[] right = new int[n];
        
        int l = a[0];
        int r = a[n - 1];
        
        // left
        for(int i = 0; i < n; i++) {
            l = Math.min(l, a[i]);
            left[i] = l;
        }
        
        // right
        for(int i = n - 1; i >= 0; i--) {
            r = Math.min(r, a[i]);
            right[i] = r;
        }
        
        // return
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            if (left[i] == a[i] || right[i] == a[i]) answer++;
        }
        
        return answer;
    }
}