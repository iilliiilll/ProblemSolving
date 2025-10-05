import java.util.*;

class Solution {
    public int solution(int[] topping) {
        if(topping.length == 1) {
            return 0;
        } else if(topping.length == 2) {
            return 1;
        }
        
        Map<Integer, Integer> hm1 = new HashMap<>();
        Map<Integer, Integer> hm2 = new HashMap<>();
        
        // hm1 : 1개, hm2: 나머지 넣기
        hm1.put(topping[0], 1);
        
        for(int i = 1; i < topping.length; i++) {
            hm2.put(topping[i], hm2.getOrDefault(topping[i], 0) + 1);
        }
        
        // 같으면 answer++
        int answer = 0;
        if(hm1.size() == hm2.size()) {
            answer++;
        }
        
        // 인덱스 1부터 hm1에 더하고, hm2에 빼기
        for(int i = 1; i < topping.length - 1; i++) {
            int num = topping[i];
            
            // hm1에 더하기
            hm1.put(num, hm1.getOrDefault(num, 0) + 1);
            
            // hm2에 빼기. 값이 0이면 제거
            hm2.put(num, hm2.get(num) - 1);
            if(hm2.get(num) == 0) {
                hm2.remove(num);
            }
            
            // 사이즈가 같으면 answer++
            if(hm1.size() == hm2.size()) {
                answer++;
            } else if(hm1.size() > hm2.size()) {
                break;
            }
        }
        
        return answer;
    }
}