import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // <장르, [고유 번호, 재생 횟수]>, <장르, 총 재생횟수> 에 삽입 -> map의 list 정렬
        Map<String, List<int[]>> map = new HashMap<>();
        Map<String, Integer> cnt = new HashMap<>();
        
        for(int i = 0; i < plays.length; i++) {
            if (!map.containsKey(genres[i])) map.put(genres[i], new ArrayList<>());
            map.get(genres[i]).add(new int[] {i, plays[i]});
            cnt.put(genres[i], cnt.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        for(String genre : map.keySet()) {
            map.get(genre).sort((a, b) -> {
                if (a[1] != b[1]) return Integer.compare(b[1], a[1]);
                return Integer.compare(a[0], b[0]);
            });
        }
        
        // 재생횟수 많은 장르별로 list 순회 -> Math.min(2, list.size()) 만큼 뽑아서 list에 추가 -> return
        List<Integer> answer = new ArrayList<>();
        
        // 재생횟수 많은 장르
        List<String> result = new ArrayList<>(cnt.keySet());
        result.sort((a, b) -> {
            return Integer.compare(cnt.get(b), cnt.get(a));
        });
                
        for(String genre : result) {
            for(int i = 0; i < Math.min(2, map.get(genre).size()); i++) answer.add(map.get(genre).get(i)[0]);
        }
        
        int[] best = new int[answer.size()];
        for(int i = 0; i < best.length; i++) best[i] = answer.get(i);
        return best;
    }
}