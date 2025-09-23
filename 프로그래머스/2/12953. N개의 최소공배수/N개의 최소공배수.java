class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            answer = (answer * arr[i]) / getGcd(answer, arr[i]);
        }
        
        return answer;
    }
    
    private int getGcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return getGcd(b, a % b);
    }
}