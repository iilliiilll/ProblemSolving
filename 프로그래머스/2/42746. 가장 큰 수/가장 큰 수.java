import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 두 문자열을 이어붙였을 때 내림차순
        Queue<String> pq = new PriorityQueue<>((a, b) -> {
            return (b + a).compareTo(a + b);
        });
        
        for(int n : numbers) {
            pq.add(String.valueOf(n));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}