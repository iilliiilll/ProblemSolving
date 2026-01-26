class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // impossible
        if (getDistance(x, y, r, c) > k || (k - getDistance(x, y, r, c)) % 2 == 1) {
            return "impossible";
        }
        
        StringBuilder sb = new StringBuilder();
        
        // d -> l -> r -> u
        while (k-- > 0) {
            int down = x + 1;
            int left = y - 1;
            int right = y + 1;
            int up = x - 1;
            
            if (down <= n && getDistance(down, y, r, c) <= k) {
                x = down;
                sb.append("d");
            } else if (left >= 1 && getDistance(x, left, r, c) <= k) {
                y = left;
                sb.append("l");
            } else if (right <= m && getDistance(x, right, r, c) <= k) {
                y = right;
                sb.append("r");
            } else if (up >= 1 && getDistance(up, y, r, c) <= k) {
                x = up;
                sb.append("u");
            }
        }
        
        return sb.toString();
    }
    
    int getDistance(int x, int y, int r, int c) {
        return Math.abs(r - x) + Math.abs(c - y);
    }
}