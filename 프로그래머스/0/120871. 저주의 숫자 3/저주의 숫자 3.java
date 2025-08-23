class Solution {
    public int solution(int n) {
        int[] arr = new int[101];
        
        int idx = 1;
        int num = 1;
        
        while(idx != 101) {
            if((num % 3 == 0) || ("" + num).contains("3")) {
                num++;
            } else {
                arr[idx++] = num++;
            }
        }
        
        return arr[n];
    }
}