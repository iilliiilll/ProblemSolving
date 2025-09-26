import java.util.*;

class Solution {
    public int solution(int[] citations) {
        /*
        0, 1, 3, 5, 6
        0편 이상 : 5개
        1편 이상 : 4개
        3편 이상 : 3개
        5편 이상 : 2개
        6편 이상 : 1개
        */
        
        Arrays.sort(citations);
        int answer = 0;
        
        for(int i = 0; i < citations.length; i++) {
            if(citations.length - i <= citations[i]) {
                answer = citations.length - i;
                break;
            }
        }
        
        return answer;
    }
}