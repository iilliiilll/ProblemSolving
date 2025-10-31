import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        
        // 배열 만들기
        int[][] arr = new int[rows][columns];
        int number = 1;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                arr[i][j] = number++;
            }
        }
        
        // 회전
        for(int[] query : queries) {
            int y1 = query[0] - 1;
            int x1 = query[1] - 1;
            int y2 = query[2] - 1;
            int x2 = query[3] - 1;
            
            // 현재 좌표
            int y = y1;
            int x = x1;
            int before = arr[y][x];
            
            int temp = 0;
            int min = arr[y][x];
            
            while(true) {
                if(y == y1 && x < x2) { // 오른쪽
                    x++;
                } else if(x == x2 && y < y2) { // 아래
                    y++;
                } else if(y == y2 && x > x1) { // 왼쪽
                    x--;
                } else if(x == x1 && y > y1) { // 위
                    y--;
                }
                
                // 교환
                temp = arr[y][x];
                arr[y][x] = before;
                before = temp;
                
                // 최소값
                min = Math.min(min, before);
                
                // 종료
                if(x == x1 && y == y1) {
                    break;
                }
            }
            
            list.add(min);
        }
        
        // return
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int i = 0; i < list.size(); i++) {
            answer[idx++] = list.get(i);
        }
        return answer;
    }
}