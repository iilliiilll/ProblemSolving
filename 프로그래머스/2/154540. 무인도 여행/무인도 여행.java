import java.util.*;

class Solution {
    static char[][] map;
    
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        
        // 배열 변환
        map = new char[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        // dfs
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] != 'X') {
                    list.add(dfs(i, j));
                }
            }
        }
        
        // return
        if(list.isEmpty()) {
            return new int[] {-1};
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    private static int dfs(int i, int j) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int sum = map[i][j] - '0';
        map[i][j] = 'X';
        
        for(int d = 0; d < 4; d++) {
            int x = i + dx[d];
            int y = j + dy[d];
            
            if(x >= 0 && y >= 0 && x < map.length && y < map[0].length && map[x][y] != 'X') {
                sum += dfs(x, y);
            }
        }
        
        return sum;
    }
}