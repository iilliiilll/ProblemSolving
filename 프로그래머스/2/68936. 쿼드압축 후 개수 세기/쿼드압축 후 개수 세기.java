class Solution {
    static int zeroCnt = 0;
    static int oneCnt = 0;
    
    public int[] solution(int[][] arr) {
        divide(arr, arr.length, 0, 0);
        
        return new int[] {zeroCnt, oneCnt};
    }
    
    private static void divide(int[][] arr, int size, int x, int y) {
        if(size == 1) {
            if(arr[x][y] == 0) {
                zeroCnt++;
            } else {
                oneCnt++;
            }
            
            return;
        }
        
        // 내부가 같은 수인지 확인
        boolean b = true;
        
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(arr[x][y] != arr[i][j]) {
                    b = false;
                    break;
                }
            }
            
            if(!b) {
                break;
            }
        }
        
        if(b) {
            // 모두 같다면 0, 1 카운트
            if(arr[x][y] == 0) {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        } else {
            // 다르면 다시 분할
            size /= 2;
            
            divide(arr, size, x, y);
            divide(arr, size, x + size, y);
            divide(arr, size, x, y + size);
            divide(arr, size, x + size, y + size);
        }
    }
}