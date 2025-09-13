class Solution {
    public int[] solution(String[] park, String[] routes) {
        boolean[][] b = new boolean[park.length][park[0].length()];
        int x = 0;
        int y = 0;

        // 배열 만들기, 현재 위치 찾기
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                if(park[i].charAt(j) != 'X') {
                    if(park[i].charAt(j) == 'S') {
                        y = i;
                        x = j;
                    }
                } else {
                    b[i][j] = true;
                }
            }
        }
        
        for(String route : routes) {
            char op = route.charAt(0);
            int d = route.charAt(2) - '0';
            boolean flag = true;
            
            if(op == 'N' && y - d >= 0) {
                for(int i = 1; i <= d; i++) {
                    if(b[y - i][x]) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) {
                    y -= d;
                }
            } else if(op == 'S' && y + d < b.length) {
                for(int i = 1; i <= d; i++) {
                    if(b[y + i][x]) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) {
                    y += d;
                }
            } else if(op == 'W' && x - d >= 0) {
                for(int i = 1; i <= d; i++) {
                    if(b[y][x - i]) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) {
                    x -= d;
                }
            } else if(op == 'E' && x + d < b[0].length) {
                for(int i = 1; i <= d; i++) {
                    if(b[y][x + i]) {
                        flag = false;
                        break;
                    } else {
                    }
                }
                
                if(flag) {
                    x += d;
                }
            }
        }
        
        return new int[] {y, x};
    }
}