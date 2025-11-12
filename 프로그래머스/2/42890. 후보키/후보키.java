import java.util.*;

class Solution {
    static List<Set<Integer>> cand = new ArrayList<>();
    static int colCount;
    
    public int solution(String[][] relation) {
        colCount = relation[0].length;
        
        // 조합 생성
        for(int size = 1; size <= colCount; size++) {
            dfs(0, size, new ArrayList<>(), relation);
        }
        
        return cand.size();
    }
    
    private static void dfs(int start, int target, List<Integer> comb, String[][] relation) {
        if(comb.size() == target) {
            // 유일성과 최소성을 만족하면
            if(isUnique(comb, relation) && isMinimal(comb)) {
                cand.add(new HashSet<>(comb));
            }
            
            return;
        }
        
        for(int i = start; i < colCount; i++) {
            comb.add(i);
            dfs(i + 1, target, comb, relation);
            comb.remove(comb.size() - 1);
        }
    }
    
    private static boolean isUnique(List<Integer> comb, String[][] relation) {
        Set<String> set = new HashSet<>();
        
        for(String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            
            // 행마다 선택된 컬럼의 값 추가
            for(int idx : comb) {
                sb.append(row[idx]).append(", ");
            }
            
            set.add(sb.toString());
        }
        
        return set.size() == relation.length;
    }
    
    private static boolean isMinimal(List<Integer> comb) {
        // 최소성을 만족하지 못하면 (후보 키 + 다른 컬럼)
        for(Set<Integer> key : cand) {
            if(comb.containsAll(key)) {
                return false;
            }
        }
        
        return true;
    }
}