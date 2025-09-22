class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int width = 0;
        int height = 0;
        
        for(int i = 1; i * i <= total; i++) {
            if(total % i == 0) {
                height = i;
                width = total / i;
                
                if(2 * (width + height) - 4 == brown) {
                    break;
                }
            }
        }
        
        return new int[] {width, height};
    }
}