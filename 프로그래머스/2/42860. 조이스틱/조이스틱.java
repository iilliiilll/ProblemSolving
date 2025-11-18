class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int len = name.length();
        int move = len - 1;
        
        char[] arr = name.toCharArray();
        for(int i = 0; i < len; i++) {
            // 위 아래
            int alpha = arr[i] - 'A';
            answer += Math.min(alpha, 26 - alpha);
            
            // 왼쪽 오른쪽
            int next = i + 1;
            while(next < len && arr[next] == 'A') {
                next++;
            }
            
            move = Math.min(move, 2 * (len - next) + i); // <- -> ->
            move = Math.min(move, 2 * i + (len - next)); // -> <- <-
        }
        
        return answer + move;
    }
}