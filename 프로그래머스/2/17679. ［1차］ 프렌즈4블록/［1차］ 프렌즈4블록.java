class Solution {
    public int solution(int m, int n, String[] board) {
        // char[][] 배열 생성
        char[][] arr = new char[m][n];
        for(int i = 0; i < board.length; i++) {
            arr[i] = board[i].toCharArray();
        }
        
        // arr 순회하며 2x2 형태의 같은 블록 탐색
        while(true) {
            // 1. 같으면 소문자로 변환
            for(int i = 0; i < m - 1; i++) {
                for(int j = 0; j < n - 1; j++) {
                    if(isSame(arr, i, j)) {
                        for(int x = i; x <= i + 1; x++) {
                            for(int y = j; y <= j + 1; y++) {
                                arr[x][y] = Character.toLowerCase(arr[x][y]);
                            }
                        }
                    }
                }
            }
            
            // 2. 모든 소문자를 공백으로 변환. 바뀐 게 없으면 break
            int cnt = 0;
            
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(Character.isLowerCase(arr[i][j])) {
                        arr[i][j] = ' ';
                        cnt++;
                    }
                }
            }
            
            if(cnt == 0) {
                break;
            }
            
            // 3. 바뀐 게 있으면 빈 공간 채우기
            for(int j = 0; j < n; j++) {
                for(int i = m - 1; i > 0; i--) {
                    if(arr[i][j] == ' ') {
                        arr = changeBlock(arr, i, j);
                    }
                }
            }
        }
        
        // return 빈 공간의 개수
        int cnt = 0;
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == ' ') {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    private static boolean isSame(char[][] arr, int i, int j) {
        char c1 = Character.toUpperCase(arr[i][j]);
        char c2 = Character.toUpperCase(arr[i][j+1]);
        char c3 = Character.toUpperCase(arr[i+1][j]);
        char c4 = Character.toUpperCase(arr[i+1][j+1]);
        
        return Character.isLetter(c1) && c1 == c2 && c2 == c3 && c3 == c4 ? true : false;
    }
        
    private static char[][] changeBlock(char[][] arr, int i, int j) {
        int idx = i - 1;
        
        while(idx >= 0) {
            if(arr[idx][j] == ' ') {
                idx--;
            } else {
                arr[i][j] = arr[idx][j];
                arr[idx][j] = ' ';
                break;
            }
        }
        
        return arr;
    }
}