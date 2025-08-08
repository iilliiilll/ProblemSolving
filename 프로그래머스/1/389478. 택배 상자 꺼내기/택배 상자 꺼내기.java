class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        // 택배 상자의 개수 : n개
        // 한 층 택배 개수 : w개
        // 꺼내야할 택배 번호 : num번
        
        // 현재 행
        int row = (num - 1) / w + 1;
        
        // 현재 열
        int col = num % w == 0 ? w : num % w;
        
        if(row % 2 == 0) {
            col = (w + 1) - col;
        }
        
        // 현재 열의 최고층
        int maxRow = 1;
        int number = col;
        
        while(true) {
            if(maxRow % 2 == 0) {
                number += 2 * col - 1;
            } else {
                number += 2 * (w + 1 - col) - 1;
            }
            
            maxRow += 1;
            
            if(number > n) {
                maxRow -= 1;
                break;
            }
        }
        
        answer = maxRow - row + 1;
        
        return answer;
    }
}