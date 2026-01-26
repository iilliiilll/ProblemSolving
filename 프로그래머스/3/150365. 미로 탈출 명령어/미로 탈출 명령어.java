import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // impossible
        if (getDistance(x, y, r, c) > k || (k - getDistance(x, y, r, c)) % 2 == 1) {
            return "impossible";
        }
        
        StringBuilder sb = new StringBuilder();
        int remain = k;
        
        // d -> l -> r -> u 순으로 검사
        for(int i = 0; i < k; i++) {
            // d
            int nx = x + 1;
            int ny = y;
            int distance = getDistance(nx, ny, r, c);
            if (nx <= n && distance <= remain - 1 && ((remain - 1) - distance) % 2 == 0) {
                x = nx;
                remain--;
                sb.append("d");
                continue;
            }
            
            // l
            nx = x;
            ny = y - 1;
            distance = getDistance(nx, ny, r, c);
            if (ny >= 1 && distance <= remain - 1 && ((remain - 1) - distance) % 2 == 0) {
                y = ny;
                remain--;
                sb.append("l");
                continue;
            }
            
            // r
            nx = x;
            ny = y + 1;
            distance = getDistance(nx, ny, r, c);
            if (ny <= m && distance <= remain - 1 && ((remain - 1) - distance) % 2 == 0) {
                y = ny;
                remain--;
                sb.append("r");
                continue;
            }
            
            // u
            nx = x - 1;
            ny = y;
            distance = getDistance(nx, ny, r, c);
            if (nx >= 1 && distance <= remain - 1 && ((remain - 1) - distance) % 2 == 0) {
                x = nx;
                remain--;
                sb.append("u");
                continue;
            }
        }
        
        return sb.toString();
    }
    
    int getDistance(int x, int y, int r, int c) {
        return Math.abs(r - x) + Math.abs(c - y);
    }
}