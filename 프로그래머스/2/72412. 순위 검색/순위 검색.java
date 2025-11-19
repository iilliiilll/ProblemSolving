import java.util.*;

class Solution {
    static Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        // info를 dfs로 16가지 경우의 수를 구해서 map에 저장
        for(String i : info) {
            StringTokenizer st = new StringTokenizer(i, " ");
            
            dfs(new String[] {st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()}, "", 0, Integer.parseInt(st.nextToken()));
        }
        
        // map의 score가 저장된 List<Integer> 오름차순 정렬
        for(List<Integer> list : map.values()) {
            list.sort((a, b) -> {
                return Integer.compare(a, b);
            });
        }
        
        // query 순회하며 key가 있으면 value를 순회 -> score보다 큰 첫 인덱스 찾기 -> list.size() - index
        int[] answer = new int[query.length];
        int idx = 0;
        
        for(String q : query) {
            int count = 0;
            
            q = q.replace(" and ", " ");
            StringTokenizer st = new StringTokenizer(q, " ");
            
            StringBuilder sb = new StringBuilder();
            String result = sb.append(st.nextToken()).append(" ").append(st.nextToken()).append(" ")
                .append(st.nextToken()).append(" ").append(st.nextToken()).append(" ").toString();
            
            int score = Integer.parseInt(st.nextToken());
            
            if(map.containsKey(result)) {
                count = findIndex(result, score);
            }
                
            answer[idx++] = count;
        }
        
        return answer;
    }
    
    private static void dfs(String[] arr, String key, int count, int score) {
        if(count == 4) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }
        
        dfs(arr, key + arr[count] + " ", count + 1, score);
        dfs(arr, key + "- ", count + 1, score);
    }
    
    private static int findIndex(String result, int score) {
        // 이진탐색
        List<Integer> list = map.get(result);
        
        int start = 0;
        int end = list.size();
        
        while(start < end) {
            int mid = start + (end - start) / 2;
            
            if(list.get(mid) < score) start = mid + 1;
            else end = mid;
        }
        
        return list.size() - start;
    }
}