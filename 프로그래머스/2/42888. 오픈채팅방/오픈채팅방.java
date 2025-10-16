import java.util.*;

class Solution {
    public String[] solution(String[] record) {        
        // userID, nickname
        Map<String, String> map = new HashMap<>();
        
        // return 배열 크기
        int n = 0;
        
        // record 순회하며 닉네임 변경. map에 추가
        StringTokenizer st;
        
        for(String r : record) {
            st = new StringTokenizer(r);
            
            String state = st.nextToken();
            String userId, nickname;
            
            if(state.equals("Enter")) {
                n++;
                userId = st.nextToken();
                nickname = st.nextToken();
            } else if(state.equals("Change")) {
                userId = st.nextToken();
                nickname = st.nextToken();
            } else {
                n++;
                continue;
            }
            
            map.put(userId, nickname);
        }
        
        // record 순회하며 String[] 출력
        String[] answer = new String[n];
        int idx = 0;
        
        for(String r : record) {
            st = new StringTokenizer(r);
            
            String state = st.nextToken();
            String name = map.get(st.nextToken());
            
            if(state.equals("Enter")) {
                answer[idx++] = name + "님이 들어왔습니다.";
            } else if(state.equals("Leave")) {
                answer[idx++] = name + "님이 나갔습니다.";
            }
        }
        
        return answer;
        
    }
}