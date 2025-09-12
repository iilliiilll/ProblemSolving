class Solution {
    public int[] solution(String[] wallpaper) {
        int left = 50;
        int right = 0;
        int top = 50;
        int down = 0;
        
        for(int i = 0; i < wallpaper.length; i++) {
            if(wallpaper[i].contains("#")) {
                // top, down
                top = Math.min(top, i);
                down = Math.max(down, i);
                
                // left, right
                left = Math.min(left, wallpaper[i].indexOf("#"));
                right = Math.max(right, wallpaper[i].lastIndexOf("#"));
            }
        }
        
        return new int[] {top, left, down + 1, right + 1};
    }
}