import java.util.*;

class Solution {
    static char[][] arr;
    
    public int solution(String[] maps) {
        // String[] -> char[]
        arr = new char[maps.length][maps[0].length()];
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] = maps[i].toCharArray();
        }
        
        // 시작, 레버, 종료 위치 저장
        int s1 = 0;
        int s2 = 0;
        int l1 = 0;
        int l2 = 0;
        int e1 = 0;
        int e2 = 0;
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 'S') {
                    s1 = i;
                    s2 = j;
                } else if(arr[i][j] == 'L') {
                    l1 = i;
                    l2 = j;
                } else if(arr[i][j] == 'E') {
                    e1 = i;
                    e2 = j;
                }
            }
        }
        
        // 시작 -> 레버, 레버 -> 종료
        int answer1 = bfs(s1, s2, l1, l2);
        if(answer1 == -1) {
            return -1;
        }
        
        int answer2 = bfs(l1, l2, e1, e2);
        if(answer2 == -1) {
            return -1;
        }

        return answer1 + answer2;
    }
    
    private static int bfs(int start1, int start2, int end1, int end2) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start1, start2, 0});
        
        // 상하좌우로 이동하면서 범위를 벗어나지 않고, 벽이 아니고, visited[]가 false이면 해당되는 방향 add, cnt++
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int cnt = temp[2];
            
            if(x == end1 && y == end2) {
                return cnt;
            }
            
            if(x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && !visited[x][y] && arr[x][y] != 'X') {
                visited[x][y] = true;
                
                q.add(new int[] {x + 1, y, cnt + 1});
                q.add(new int[] {x - 1, y, cnt + 1});
                q.add(new int[] {x, y + 1, cnt + 1});
                q.add(new int[] {x, y - 1, cnt + 1});
            }
        }
        
        return -1;
    }
}