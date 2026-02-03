import java.util.*;

class Solution {
    static boolean[][] pillar;
    static boolean[][] beam;
    static int N;
    
    public int[][] solution(int n, int[][] build_frame) {
        N = n;
        pillar = new boolean[n + 1][n + 1];
        beam = new boolean[n + 1][n + 1];
        
        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int struct = frame[2];
            int install = frame[3];
            
            if (install == 1) { // 설치
                if (canInstall(x, y, struct)) {
                    if (struct == 0) pillar[x][y] = true;
                    else beam[x][y] = true;
                }
            } else { // 삭제
                if (struct == 0) pillar[x][y] = false;
                else beam[x][y] = false;
                
                if (!isValid(x, y)) {
                    if (struct == 0) pillar[x][y] = true;
                    else beam[x][y] = true;
                }
            }
        }
        
        return makeAnswer();
    }
    
    static boolean canInstall(int x, int y, int struct) {
        if (struct == 0) { // 기둥
            return y == 0 || (y > 0 && pillar[x][y - 1]) || beam[x][y]|| (x > 0 && beam[x - 1][y]);
        } else { // 보
            return (y > 0 && pillar[x][y - 1]) || (y > 0 && x + 1 <= N && pillar[x + 1][y - 1]) || (x > 0 && x + 1 <= N && beam[x - 1][y] && beam[x + 1][y]);
        }
    }
    
    static boolean isValid(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y; j <= y + 1; j++) {
                if (i < 0 || j < 0 || i > N || j > N) continue;
                
                if (pillar[i][j] && !canInstall(i, j, 0)) return false;
                if (beam[i][j] && !canInstall(i, j, 1)) return false;
            }
        }
        
        return true;
    }
    
    static int[][] makeAnswer() {
        List<int[]> list = new ArrayList<>();
        
        for (int x = 0; x <= N; x++) {
            for (int y = 0; y <= N; y++) {
                if (pillar[x][y]) list.add(new int[] {x, y, 0});
                if (beam[x][y]) list.add(new int[] {x, y, 1});
            }
        }
        
        list.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        
        int[][] answer = new int[list.size()][3];
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}