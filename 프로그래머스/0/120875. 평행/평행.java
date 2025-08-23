class Solution {
    public int solution(int[][] dots) {
        // case 1 : 01 23
        int[] x = get(dots[0], dots[1]);
        int[] y = get(dots[2], dots[3]);
        
        if(x[0] * y[1] == x[1] * y[0]) {
            return 1;
        }
        
        // case 2 : 02 13
        x = get(dots[0], dots[2]);
        y = get(dots[1], dots[3]);
        
        if(x[0] * y[1] == x[1] * y[0]) {
            return 1;
        }
        
        // case 3 : 03 12
        x = get(dots[0], dots[3]);
        y = get(dots[1], dots[2]);
        
        if(x[0] * y[1] == x[1] * y[0]) {
            return 1;
        }
        
        return 0;
    }
    
    private int[] get(int[] a, int[] b) {
        int[] arr = new int[2];
        
        arr[0] = b[0] - a[0];
        arr[1] = b[1] - a[1];
        
        return arr;
    }
}