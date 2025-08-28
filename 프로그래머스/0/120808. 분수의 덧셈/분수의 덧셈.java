class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        int numer = (numer1 * denom2) + (numer2 * denom1);
        int denom = denom1 * denom2;

        int gcd = getGCD(numer, denom);
        
        answer[0] = numer / gcd;
        answer[1] = denom / gcd;
        
        return answer;
    }
    
    private int getGCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        
        return getGCD(b, a % b);
    }
}