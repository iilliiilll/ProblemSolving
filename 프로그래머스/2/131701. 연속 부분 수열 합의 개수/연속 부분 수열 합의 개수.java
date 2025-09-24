import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> hs = new HashSet<>();
        int n = elements.length;
        int[] arr = new int[2 * n + 1];
        
        for(int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + elements[(i - 1) % n];
        }
        
        for(int len = 1; len <= elements.length; len++) {
            for(int i = 0; i < n; i++) {
                hs.add(arr[i + len] - arr[i]);
            }
        }
        
        return hs.size();
    }
}