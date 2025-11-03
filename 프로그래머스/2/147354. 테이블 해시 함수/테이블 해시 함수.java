import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // col 번째 컬럼의 값 오름차순 - 기본키(첫 번째 컬럼) 값 내림차순
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[col - 1] != b[col - 1]) {
                return Integer.compare(a[col - 1], b[col - 1]);
            }
            
            return Integer.compare(b[0], a[0]);
        });
        
        // pq에 넣기
        for(int[] d : data) pq.add(d);
        
        // row_begin 전까지 빼기
        for(int i = 1; i < row_begin; i++) pq.poll();
        
        // return
        int answer = divide(pq.poll(), row_begin);
        
        for(int i = row_begin + 1; i <= row_end; i++) {
            int n = divide(pq.poll(), i);
            answer = answer ^ n;
        }
        
        return answer;
    }
    
    private static int divide(int[] arr, int row) {
        int num = 0;
        
        for(int a : arr) {
            num += a % row;
        }
        
        return num;
    }
}