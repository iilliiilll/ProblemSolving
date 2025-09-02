import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        // for(int i = 0; i < photo.length; i++) {
        //     answer[i] = getScore(photo[i], name, yearning);
        // }
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for(int i = 0; i < photo.length; i++) {
            int sum = 0;
            
            for(int j = 0; j < photo[i].length; j++) {
                sum += map.getOrDefault(photo[i][j], 0);
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }
    
//     private int getScore(String[] people, String[] name, int[] yearning) {
//         int sum = 0;
        
//         for(String str : people) {
//             for(int i = 0; i < name.length; i++) {
//                 if(str.equals(name[i])) {
//                     sum += yearning[i];
//                     break;
//                 }
//             }
//         }
        
//         return sum;
//     }
}