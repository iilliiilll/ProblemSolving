class Solution {
    public int[] solution(int n, int s) {
        // 합이 s가 안되면 return
        if(s < n) return new int[] {-1};
        
        // 초기값 설정
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) answer[i] = s / n;
        
        // 남은 횟수동안 뒤에서부터 +1
        for(int i = 0; i < s % n; i++) answer[n - i - 1]++;
        
        return answer;
    }
}