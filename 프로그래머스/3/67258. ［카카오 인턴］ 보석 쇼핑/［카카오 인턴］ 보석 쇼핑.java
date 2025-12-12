import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 전체 보석 종류의 개수
        Set<String> set = new HashSet<>();
        for(String gem : gems) set.add(gem);
        int total = set.size();
        
        // 투포인터
        Map<String, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int bestL = 0;
        int bestR = gems.length - 1;
        int found = 0;
                
        while (true) {
            if (found < total) { // right. 찾기
                if (right == gems.length) break;
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                if (map.get(gems[right]) == 1) found++;
                right++;
            } else { // left. 줄이기
                if ((right - 1) - left < bestR - bestL) {
                    bestL = left;
                    bestR = right - 1;
                }
                
                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) found--;
                left++;
            }
        }

        return new int[] {bestL + 1, bestR + 1};
    }
}