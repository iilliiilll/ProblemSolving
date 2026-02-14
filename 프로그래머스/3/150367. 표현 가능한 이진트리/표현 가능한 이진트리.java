import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        // 2진수로 변환
        for (int i = 0; i < numbers.length; i++) {
            String bStr = Long.toString(numbers[i], 2);
            
            // 포화이진트리 노드의 개수에 맞게 길이 추가
            int len = bStr.length();
            
            int k = 0;
            while (Math.pow(2, k) - 1 < len) k++;
            
            int need = (int) Math.pow(2, k) - 1 - len;
            
            // 길이에 맞게 맨 앞에 0 추가
            StringBuilder sb = new StringBuilder(bStr);
            sb.insert(0, "0".repeat(need));
            bStr = sb.toString();
            
            // 0 밑에 1이 있으면 안됨
            answer[i] = checkTree(bStr, 0, bStr.length() - 1) ? 1 : 0;
        }
        
        return answer;
    }
    
    private static boolean checkTree(String bStr, int start, int end) {
        if (start == end) return true;
        
        int mid = start + (end - start) / 2;
        
        // left, right에 1이 있으면 안됨
        if (bStr.charAt(mid) == '0') {
            for(int i = start; i <= end; i++) {
                if (i == mid) continue;
                if (bStr.charAt(i) == '1') return false;
            }
            return true;
        }
        
        return checkTree(bStr, start, mid - 1) && checkTree(bStr, mid + 1, end);
    }
}