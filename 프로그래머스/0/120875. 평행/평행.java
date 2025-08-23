class Solution {
    static int[][] dots;
    
    public int solution(int[][] dots) {
        Solution.dots = dots;
        
        if(get(0, 1, 2, 3)) {
            return 1;
        }
        
        if(get(0, 2, 1, 3)) {
            return 1;
        }
        
        if(get(0, 3, 1, 2)) {
            return 1;
        }

        return 0;
    }
    
    private boolean get(int a, int b, int c, int d) {
        int x = (dots[b][1] - dots[a][1]) * (dots[d][0] - dots[c][0]);
        int y = (dots[b][0] - dots[a][0]) * (dots[d][1] - dots[c][1]);
        
        return x == y || x == -y;
    }
}