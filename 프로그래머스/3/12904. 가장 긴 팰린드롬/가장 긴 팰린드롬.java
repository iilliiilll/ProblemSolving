class Solution {
    public int solution(String s) {
        int answer = 1;
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            if ((arr.length - i) * 2 < answer) break;
            answer = Math.max(answer, isSame(arr, i));
        }
        
        return answer;
    }
    
    private static int isSame(char[] arr, int idx) {
        int max = 0;

        // 홀수
        int count = 0;
        while (idx-count >= 0 && idx+count < arr.length && arr[idx-count] == arr[idx+count]) count++;
        max = Math.max(max, 2 * count - 1);

        // 짝수
        count = 0;
        while(idx-count >= 0 && idx+1+count < arr.length && arr[idx-count] == arr[idx+1+count]) count++;
        max = Math.max(max, 2 * count);
        
        return max;
    }
}