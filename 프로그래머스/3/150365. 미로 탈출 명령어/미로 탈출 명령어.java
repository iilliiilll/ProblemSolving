import java.util.*;

class Solution {
    /*
    n x m 격자 미로: (x, y) -> (r, c)
        1. 격자 안에서만 이동
        2. 이동 거리는 총 k. (중복 방문 가능)
        3. 탈출 경로 -> 문자열: 사전 순으로 가장 빠른 경로로 탈출 (d -> l -> r -> u)
            l: 왼쪽, r: 오른쪽, u: 위, d: 아래
        return 탈출 경로. 안되면 "impossible"
    2 <= n, m <= 50
    1 <= x, r <= n
    1 <= y, c <= m
    1 <= k <= 2,500
    풀이
        bfs? dp? -> 이동하면서 사전 순으로 계속 교체?
            d, l, r, u 순으로 계속 이동하다가 현재 위치와 (r, c)와의 거리가 남은 k와 같으면 bfs
    */
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // impossible 구하기
        if (k % 2 != (getDistance(x, y, r, c) % 2)) return "impossible";
        
        // d -> l -> r, l 번갈아 (현재 위치와 (r, c)와의 거리가 k와 같을 때까지)
        StringBuilder sb = new StringBuilder();
        
        while (x < n && getDistance(x + 1, y, r, c) < k - 1) {
            x++;
            k--;
            sb.append("d");
        }
        
        while (y > 1 && getDistance(x, y - 1, r, c) < k - 1) {
            y--;
            k--;
            sb.append("l");
        }
        
        boolean dir = false;
        
        while (true) {
            if (!dir && y < m && getDistance(x, y + 1, r, c) < k - 1) {
                y++;
                sb.append("r");
            } else if (dir && 1 < y && getDistance(x, y - 1, r, c) < k - 1) {
                y--;
                sb.append("l");
            } else {
                break;
            }

            dir = !dir;
            k--;
        }
        
        // (x, y)에서 (r, c)까지 이동하기: d -> l -> r -> u 순
        if (x < r) sb.append("d".repeat(r - x));
        
        if (y > c) sb.append("l".repeat(y - c));
        else if (y < c) sb.append("r".repeat(c - y));
        
        if (x > r) sb.append("u".repeat(x - r));
        
        return sb.toString();
    }
    
    int getDistance(int x, int y, int r, int c) {
        return Math.abs(r - x) + Math.abs(c - y);
    }
}