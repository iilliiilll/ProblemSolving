import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Arrays.sort(nums);
        
        int cnt = 1;
        int num = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if(cnt == nums.length / 2) {
                break;
            }
            
            if(num != nums[i]) {
                cnt++;
                num = nums[i];
            }
        }
        
        return cnt;
    }
}