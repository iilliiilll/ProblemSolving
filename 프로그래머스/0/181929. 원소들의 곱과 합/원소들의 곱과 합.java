class Solution {
    public int solution(int[] num_list) {
        int mul = 1;
        int sum = 0;
        
        for(int n : num_list) {
            mul *= n;
            sum += n;
        }
        
        sum = sum * sum;
        
        return mul < sum ? 1 : 0;
    }
}