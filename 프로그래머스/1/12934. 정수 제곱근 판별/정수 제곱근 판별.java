class Solution {
    public long solution(long n) {
        long a = (long) Math.sqrt(n);
        
        return (long) Math.pow(a, 2) == n ? (long) Math.pow(a + 1, 2) : -1;
    }
}