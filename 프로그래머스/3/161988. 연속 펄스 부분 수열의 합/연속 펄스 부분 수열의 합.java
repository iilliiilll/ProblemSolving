class Solution {
    public long solution(int[] sequence) {
        // 카데인 알고리즘
        int n = sequence.length;
        
        long a = sequence[0];
        long b = -sequence[0];
        long max = Math.max(a, b);
        
        for(int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                a = Math.max(a + sequence[i], sequence[i]);
                b = Math.max(b - sequence[i], -sequence[i]);
            } else {
                a = Math.max(a - sequence[i], -sequence[i]);
                b = Math.max(b + sequence[i], sequence[i]);
            }
            
            max = Math.max(max, Math.max(a, b));
        }
        
        return max;
    }
}