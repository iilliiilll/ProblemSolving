import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static List<String> list = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        // orders, course 처리
        list.clear();
        for(int c : course) {
            map.clear();
            
            for(String order : orders) {
                char[] ch = order.toCharArray();
                Arrays.sort(ch);
                getCount(String.valueOf(ch), c);
            }
            
            addList();
        }
        
        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    private static void getCount(String order, int course) {
        // order에서 course 글자 수 뽑아내기
        if(order.length() < course) {
            return;
        } else if(order.length() == course) {
            map.put(order, map.getOrDefault(order, 0) + 1);
        } else {
            dfs("", order, 0, course);
        }
    }
    
    private static void dfs(String cur, String target, int cnt, int count) {        
        if(cur.length() == count) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            return;
        }
        
        for(int i = cnt; i < target.length(); i++) {
            dfs(cur + target.charAt(i), target, i + 1, count);
        }
    }
    
    private static void addList() {
        int max = -1;
        
        for(String s : map.keySet()) {
            if(max < map.get(s)) {
                max = map.get(s);
            }
        }
        
        if(max >= 2) {
            for(String s : map.keySet()) {
                if(map.get(s) == max) {
                    list.add(s);
                }
            }
        }
    }
}