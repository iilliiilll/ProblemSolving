import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int idx = 0;
        
        for(int[] ball : balls) {
            // 원쿠션
            answer[idx++] = one(m, n, startX, startY, ball[0], ball[1]);
        }
        
        return answer;
    }
    
    private static int one(int m, int n, int startX, int startY, int endX, int endY) {
        int dist = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;
        
        // 위로 치기 : x좌표가 같고, 시작 y좌표가 목표 y좌표보다 작거나 같으면 안됨
        if(startX != endX || startY > endY) {
            x = endX - startX;
            y = (n + (n - endY)) - startY;
            dist = Math.min(dist, x * x + y * y);
        }
        
        // 아래로 치기 : x좌표가 같고, 시작 y좌표가 목표 y좌표보다 크거나 같으면 안됨
        if(startX != endX || startY < endY) {
            x = endX - startX;
            y = (-endY) - startY;
            dist = Math.min(dist, x * x + y * y);
        }
        
        // 오른쪽으로 치기 : y좌표가 같고, 시작 x좌표가 목표 x좌표보다 작거나 같으면 안됨
        if(startY != endY || startX > endX) {
            x = (m + (m - endX)) - startX;
            y = endY - startY;
            dist = Math.min(dist, x * x + y * y);
        }
        
        // 왼쪽으로 치기 : y좌표가 같고, 시작 x좌표가 목표 x좌표보다 크거나 같으면 안됨
        if(startY != endY || startX < endX) {
            x = (-endX) - startX;
            y = endY - startY;
            dist = Math.min(dist, x * x + y * y);
        }
        
        return dist;
    }
}