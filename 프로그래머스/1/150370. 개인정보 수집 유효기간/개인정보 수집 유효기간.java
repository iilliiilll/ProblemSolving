import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<Character, Integer> hm = new HashMap<>();
        List<Integer> ar = new ArrayList<>();
        StringTokenizer st;
        
        // today
        st = new StringTokenizer(today, ".");
        
        int todayYear = Integer.parseInt(st.nextToken());
        int todayMonth = Integer.parseInt(st.nextToken());
        int todayDay = Integer.parseInt(st.nextToken());
        
        // terms
        for(String term : terms) {
            st = new StringTokenizer(term);
            hm.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
        }
        
        // privacies
        for(int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i]);
            String date = st.nextToken();
            char ch = st.nextToken().charAt(0);
            
            // privacies - date + ch
            st = new StringTokenizer(date, ".");
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken()) + hm.get(ch);
            int day = Integer.parseInt(st.nextToken());
            
            year += (month - 1) / 12;
            month = (month - 1) % 12 + 1;
            
            // today vs date
            if(todayYear > year) {
                ar.add(i + 1);
            } else if(todayYear == year) {
                if(todayMonth > month) {
                    ar.add(i + 1);
                } else if(todayMonth == month) {
                    if(todayDay >= day) {
                        ar.add(i + 1);
                    }
                }
            }
        }
        
        int[] answer = new int[ar.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = ar.get(i);
        }
        
        return answer;
    }
}