class Solution {
    public int[] solution(int[] arr) {
        int min = 100000;
        int max = -1;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 2) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        
        if(max == -1) {
            return new int[] { -1 };
        } else if(min == max) {
            return new int[] { 2 };
        } else {
            int[] answer = new int[max - min + 1];
            
            for(int i = min, idx = 0; i <= max; i++) {
                answer[idx++] = arr[i];
            }
            
            return answer;
        }
    }
}