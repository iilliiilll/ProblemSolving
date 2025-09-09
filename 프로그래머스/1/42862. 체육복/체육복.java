import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int l : lost) {
            set1.add(l);
        }
        
        for(int r : reserve) {
            set2.add(r);
        }
        
        for(int l : lost) {
            if(set2.contains(l)) {
                set2.remove(l);
            }
        }
        
        for(int r : reserve) {
            if(set1.contains(r)) {
                set1.remove(r);
            }
        }
        
        int count = 0;
        
        for(int l : set1) {
            if(set2.contains(l - 1)) {
                count++;
                set2.remove(l - 1);
            } else if(set2.contains(l + 1)) {
                count++;
                set2.remove(l + 1);
            }
        }
        
        return n - set1.size() + count;
    }
}