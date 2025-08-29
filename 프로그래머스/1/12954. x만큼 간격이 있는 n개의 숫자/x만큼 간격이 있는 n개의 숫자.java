class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int idx = 0;
        int cnt = 0;
        
        while(cnt != n) {
            answer[idx++] = (long) x * (cnt + 1);
            cnt++;
        }
        
        
        return answer;
    }
}