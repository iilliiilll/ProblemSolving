import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        
        int[] dice = new int[] {a, b, c, d};
        Arrays.sort(dice);
        a = dice[0];
        b = dice[1];
        c = dice[2];
        d = dice[3];
        
        if(a == d) {
            answer = 1111 * a;
        } else if(a != b && b != c && c != d && d != a) {
            answer = a;
        } else if(a == c) {
            answer = (int) Math.pow((10 * a + d), 2);
        } else if(b == d) {
            answer = (int) Math.pow((10 * d + a), 2);
        } else if(a == b) {
            if(c == d) {
                answer = (c + a) * (c - a);
            } else {
                answer = c * d;
            }
        } else if(b == c) {
            answer = a * d;
        } else if(c == d) {
            if(a == b) {
                answer = (c + a) * (c - a);
            } else {
                answer = a * b;
            }
        }
        
        return answer;
    }
}