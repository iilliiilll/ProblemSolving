class Solution {
    public int solution(String[] strArr) {
        int max = 0;
        int[] arr = new int[31];
        
        for(int i = 0; i < strArr.length; i++) {
            int len = strArr[i].length();
            
            arr[len]++;
        }
        
        for(int i = 1; i < 31; i++) {
            max = Math.max(max, arr[i]);
        }
        
        return max;
    }
}