class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];
        
        for(int i = 0; i < answer.length; i++) {
            int n = (int) (begin + i);
            
            if(n == 1) answer[i] = 0;
            else if(n == 2 || n == 3) answer[i] = 1;
            else answer[i] = get(n);
        }
        
        return answer;
    }
    
    // 1000만 이하 + 자신을 제외한 가장 큰 약수
    private static int get(int n) {
        int max = 1;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i <= 10_000_000) return (n / i); // 점점 작아짐
                if (i <= 10_000_000) max = i; // 점점 커짐
            }
        }

        return max;
    }
}