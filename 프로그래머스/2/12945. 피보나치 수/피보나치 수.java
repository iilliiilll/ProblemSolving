class Solution {
    public int solution(int n) {
//         int[] fib = new int[n + 1];
        
//         fib[0] = 0;
//         fib[1] = 1;
        
//         for(int i = 2; i <= n; i++) {
//             fib[i] = (fib[i - 1] + fib[i - 2]) % 1234567;
//         }
        
//         return fib[n] % 1234567;
        
        int f1 = 0;
        int f2 = 1;
        int answer = 0;
        
        for(int i = 2; i <= n; i++) {
            answer = (f1 + f2) % 1234567;
            f1 = f2;
            f2 = answer;
        }
        
        return answer % 1234567;
    }
}