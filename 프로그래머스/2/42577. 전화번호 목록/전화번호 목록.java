import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> hs = new HashSet<>();
        
        // 다 넣기
        for(String phone : phone_book) {
            hs.add(phone);
        }
        
        // 인덱스 0부터 len(str) - 1까지 검사하면서 같은지 확인
        for(String phone : phone_book) {
            for(int i = 1; i < phone.length(); i++) {
                String temp = phone.substring(0, i);
                
                if(hs.contains(temp)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}