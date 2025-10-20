class Solution {
    public int[] solution(int n) {
        // nxn 2차원 배열 생성
        int[][] arr = new int[n][n];

        // n을 벗어나지 않고, 0이 아니라면 값 대입
        int num = 1;
        int row = 0;
        int col = 0;

        while(true) {
            int change = 0;

            // 아래
            while(isGood(arr, row, col)) {
                arr[row++][col] = num++;
                change++;
            }
            row--;
            col++;

            // 오른쪽
            while(isGood(arr, row, col)) {
                arr[row][col++] = num++;
                change++;
            }
            col--;
            row--;
            col--;

            // 왼쪽 위
            while(isGood(arr, row, col)) {
                arr[row--][col--] = num++;
                change++;
            }
            row++;
            col++;
            row++;
            
           if(change == 0) {
                break;
            }
        }

        // return
        int[] answer = new int[(n * (n + 1)) / 2];
        int idx = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }
    
    private static boolean isGood(int[][] arr, int row, int col) {
        if(row >= 0 && col >= 0 && row < arr.length && col <= row && arr[row][col] == 0) {
            return true;
        } else {
            return false;
        }
    }
}