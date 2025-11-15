import java.util.*;

class Solution {
    static int row;
    static int col;
    static int[][] arr;
    static boolean[][] visited;
    static Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        
        row = land.length;
        col = land[0].length;
        
        arr = new int[row][col];
        visited = new boolean[row][col];
        
        // 석유 덩어리 넓이 구하기 : arr에 (석유 덩어리 번호, 넓이) 저장
        int temp = 2;
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    bfs(land, temp, i, j);
                    temp++;
                }
            }
        }
        
        // 최대 석유량 구하기
        for(int c = 0; c < col; c++) {
            boolean[] used = new boolean[temp + 1];
            int oil = 0;
            
            for(int r = 0; r < row; r++) {
                int num = arr[r][c];
                
                if(!used[num]) {
                    used[num] = true;
                    oil += map.getOrDefault(num, 0);
                }
            }
            
            answer = Math.max(answer, oil);
        }
        
        return answer;
    }
    
    private static void bfs(int[][] land, int number, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;
        arr[r][c] = number;
        
        int size = 1;
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        
        while(!q.isEmpty()) {
            int[] xy = q.poll();
            int y = xy[0];
            int x = xy[1];
            
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny >= 0 && nx >= 0 && ny < row && nx < col && land[ny][nx] == 1 && !visited[ny][nx]) {
                    q.add(new int[] {ny, nx});
                    visited[ny][nx] = true;
                    arr[ny][nx] = number;
                    size++;
                }
            }
        }
        
        map.put(number, size);
        
        return;
    }
}