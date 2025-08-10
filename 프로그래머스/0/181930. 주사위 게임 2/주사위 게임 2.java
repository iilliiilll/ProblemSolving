class Solution {
    public int solution(int a, int b, int c) {
        int x = a + b + c;
        int y = (int) (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
        int z = (int) (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));
            
        int answer = 0;
        
        if (a != b && b != c && c != a) {
            answer = x;
        } else if (a == b && b == c) {
            answer = x * y * z;
        } else {
            answer = x * y;
        }
        
        return answer;
    }
}