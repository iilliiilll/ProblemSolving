class Solution {
    // n명을 보냈을 때 건널 수 있는지? (이분탐색)
    public int solution(int[] stones, int k) {
        int start = 1;
        int end = 200_000_000;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (canJump(stones, mid, k)) start = mid + 1;
            else end = mid - 1;
        }
        
        return start - 1;
    }
    
    private static boolean canJump(int[] stones, int n, int k) {
        int count = 0;
        
        for(int i = 0; i < stones.length; i++) {
            if (stones[i] - n < 0) count++;
            else count = 0;
            
            if (count == k) return false;
        }
        
        return true;
    }
}