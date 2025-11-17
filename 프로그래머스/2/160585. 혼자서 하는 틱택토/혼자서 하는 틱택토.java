class Solution {
    static char[][] arr = new char[3][3];
    static int answer = 0;
    
    public int solution(String[] board) {
        // 배열 변환
        for(int i = 0; i < 3; i++) arr[i] = board[i].toCharArray();
        
        // 개수 세기
        int o = 0;
        int x = 0;
        
        for(char[] ch : arr) {
            for(char c : ch) {
                if(c == 'O') o++;
                else if(c == 'X') x++;
            }
        }
        
        if(Math.abs(o - x) > 1) { // 개수 차가 1개가 넘으면 불가능
            answer = 0;
        } else if(o < x) { // x가 더 많으면 불가능
            answer = 0;
        } else if(o == 0 && x == 0) { // 모두 비어있으면 가능
            answer = 1;
        } else if(o == x) {
            if(isBingo('O')) {
                answer = 0;
            } else if(isBingo('X')) {
                answer = 1;
            } else {
                answer = 1;
            }
        } else if(o > x) {
            if(isBingo('X')) {
                answer = 0;
            } else if(isBingo('O')) {
                answer = 1;
            } else {
                answer = 1;
            }
        }
        
        return answer;
    }
    
    // 빙고
    private static boolean isBingo(char ch) {
        if(check1(ch) || check2(ch)) return true;
        return false;
    }
    
    // 가로, 세로
    private static boolean check1(char ch) {
        for(int i = 0; i < 3; i++) {
            if((arr[i][0] == ch && arr[i][1] == ch && arr[i][2] == ch) || 
                (arr[0][i] == ch && arr[1][i] == ch && arr[2][i] == ch)) return true;
        }
        
        return false;
    }
    
    // \, /
    private static boolean check2(char ch) {
        if(arr[1][1] == ch && 
           (arr[0][0] == ch && arr[2][2] == ch) || (arr[0][2] == ch && arr[2][0] == ch)) return true;

        return false;
    }
}