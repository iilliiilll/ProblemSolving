import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int count = seller.length;
        
        // [사람, 돈]
        Map<String, Integer> money = new HashMap<>();
        
        // [자식, 부모]
        Map<String, String> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            map.put(enroll[i], referral[i]);
            money.put(enroll[i], 0);
        }
        
        // 계산
        for(int i = 0; i < count; i++) {
            String name = seller[i];
            int price = amount[i] * 100;
            
            while(!name.equals("-") && price != 0) {
                // 자식
                money.put(name, money.get(name) + (price - price / 10));
                
                // 부모
                name = map.get(name);
                price = price / 10;
            }
        }
        
        // return
        int[] answer = new int[n];
        int idx = 0;
        for(int i = 0; i < n; i++) answer[idx++] = money.get(enroll[i]);
        return answer;
    }
}