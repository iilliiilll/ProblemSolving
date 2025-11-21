import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        Set<String> set = new HashSet<>();
        
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        // line 순회하면서 교점 구하기
        for(int i = 0; i < line.length - 1; i++) {
            for(int j = i + 1; j < line.length; j++) {
                // 분모가 0인지 확인
                long down = ((long) line[i][0] * line[j][1]) - ((long) line[i][1] * line[j][0]);
                if(down == 0) continue;
                
                long upX = ((long) line[i][1] * line[j][2]) - ((long) line[i][2] * line[j][1]);
                long upY = ((long) line[i][2] * line[j][0]) - ((long) line[i][0] * line[j][2]);
                
                // 나눈 결과가 정수면 set에 추가
                if(upX % down != 0 || upY % down != 0) continue;
                
                int x = (int) (upX / down);
                int y = (int) (upY / down);
                
                set.add(x + ", " + y);
                
                // 결과 배열 크기 정하기
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }
        
        // max만큼의 배열 생성
        StringBuilder sb;
        String[] answer = new String[maxY - minY + 1];
        int idx = 0;
        
        for(int y = maxY; y >= minY; y--) {
            sb = new StringBuilder();
            
            for(int x = minX; x <= maxX; x++) {
                if(set.contains(x + ", " + y)) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            
            answer[idx++] = sb.toString();
        }
        
        return answer;
    }
}