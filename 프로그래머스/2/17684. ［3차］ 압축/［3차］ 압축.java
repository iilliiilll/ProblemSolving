import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        // HashMap에 A~Z 넣기
        for(int i = 1; i <= 26; i++) {
            map.put(String.valueOf((char)('A' + i - 1)), i);
        }
        
        // 현재 사전 위치
        int cur = 27;
        
        // 현재 배열 인덱스 위치
        char[] arr = msg.toCharArray();
        int idx = 0;
        
        // 2, 3, 4
        while(true) {
            // 2. 가장 긴 문자열 찾기
            String temp = String.valueOf(arr[idx++]);
            
            while(idx < arr.length) {
                if(map.containsKey(temp + arr[(idx)])) {
                    temp += arr[idx++];
                } else {
                    break;
                }
            }
            
            // 3. list에 인덱스 삽입
            list.add(map.get(temp));
            
            // 4. 다음 글자가 있다면 현재+다음 등록
            if(idx > arr.length - 1) {
                break;
            } else {
                map.put(temp + arr[idx], cur++);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}