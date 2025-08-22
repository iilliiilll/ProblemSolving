class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0];
        int diff = Math.abs(n - array[0]);
        
        for(int i : array) {
            if(Math.abs(n - i) < diff) {
                diff = Math.abs(n - i);
                answer = i;
            } else if(Math.abs(n - i) == diff) {
                answer = Math.min(answer, i);
            }
        }
        
        return answer;
    }
}