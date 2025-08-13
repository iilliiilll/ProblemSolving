class Solution {
    public int solution(int[] arr) {
        int max = -1;
        
        for(int i = 0; i < arr.length; i++) {
            int cnt = 0;
            int n = arr[i];
            
            while((n % 2 == 0 && n >= 50) || (n % 2 == 1 && n < 50)) {
                n = n >= 50 ? n / 2 : n * 2 + 1;
                cnt++;
            }
            
            max = Math.max(max, cnt);
        }
        
        return max;
    }
}