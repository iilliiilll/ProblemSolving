class Solution {
    public long[] solution(long[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            if((numbers[i] & 1) == 0) {
                // 짝수면 +1
                numbers[i]++;
            } else {
                // 홀수면 맨 오른쪽의 0 -> 1, 0 오른쪽의 1 -> 0
                long zero = Long.lowestOneBit(~numbers[i]);
                numbers[i] += zero - (zero >> 1);
            }
        }
        
        return numbers;
    }
}