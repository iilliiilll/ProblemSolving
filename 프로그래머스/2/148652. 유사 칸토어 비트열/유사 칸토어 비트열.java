class Solution {
    public int solution(int n, long l, long r) {
        return countOne(n, r) - countOne(n, l - 1);
    }
    
    private static int countOne(int n, long k) {
        if(k <= 0) return 0;
        if(n == 0) return 1;
        
        // 현재 레벨의 한 블록 크기
        long partSize = (long) Math.pow(5, n - 1); 
        
        // 현재 k의 블록 순서
        long section = k / partSize;
        long remainder = k % partSize;
        
        // 이전 단계에서 1의 개수
        long prevOnes = (long) Math.pow(4, n - 1);
        
        long result = 0;
        
        if(section < 2) { // 앞에 나온 section 추가하고, 현재 section에서 1의 개수 다시 구하기
            result += section * prevOnes;
            result += countOne(n - 1, remainder);
        } else if(section == 2) { // section 0, 1만 추가하기
            result += 2 * prevOnes;
        } else { // 2를 제외한 앞에 나온 section 추가하고, 현재 section에서 1의 개수 다시 구하기
            result += (section - 1) * prevOnes;
            result += countOne(n - 1, remainder);
        }
        
        return (int) result;
    }
}