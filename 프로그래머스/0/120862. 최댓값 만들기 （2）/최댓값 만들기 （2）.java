import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int len = numbers.length;
        
        Arrays.sort(numbers);
        
        int min = numbers[0] * numbers[1];
        int max = numbers[len - 1] * numbers[len - 2];
        
        return Math.max(min, max);
    }
}