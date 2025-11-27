import java.util.*;

class Solution {
    public int[] solution(String[] grid) {
        List<Integer> list = new ArrayList<>();
        
        // 행열 길이 구하기
        int row = grid.length;
        int col = grid[0].length();
        
        // [행][열][동서남북] - 동(0) 서(1) 남(2) 북(3)
        boolean[][][] out = new boolean[row][col][4];
    
        // arr 배열 생성
        char[][] arr = new char[row][col];
        for(int i = 0; i < row; i++) arr[i] = grid[i].toCharArray();
        
        // out 돌면서 false이면 true로 변환
        for(int i = 0; i < out.length; i++) {
            for(int j = 0; j < out[i].length; j++) {
                for(int k = 0; k < out[i][j].length; k++) {
                    if(!out[i][j][k]) light(i, j, k, row, col, arr, list, out);
                }
            }
        }
        
        // return
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = list.get(i);  
        Arrays.sort(answer);
        return answer;
    }
    
    private static void light(int r, int c, int k, int row, int col, char[][] arr, List<Integer> list, boolean[][][] out) {
        int count = 0;
        
        while(true) {
            // 방문하면 카운트 증가
            out[r][c][k] = true;
            count++;
            
            // 다음 방향 구하고
            k = getWhere(r, c, k, arr);
            
            // 이동
            if(k == 0) c = (c + 1) % col;
            else if(k == 1) c = (col + c - 1) % col;
            else if(k == 2) r = (r + 1) % row;
            else r = (row + r - 1) % row;
            
            // break
            if(out[r][c][k]) break;
        }
        
        list.add(count);
    }
    
    private static int getWhere(int r, int c, int k, char[][] arr) {
        if(arr[r][c] == 'S') {
            return k;
        } else if(arr[r][c] == 'R') {
            if (k == 0) return 2;
            else if (k == 1) return 3;
            else if (k == 2) return 1;
            else if (k == 3) return 0;
        } else {
            if (k == 0) return 3;
            else if (k == 1) return 2;
            else if (k == 2) return 0;
            else if (k == 3) return 1;
        }
        
        return -1;
    }
}