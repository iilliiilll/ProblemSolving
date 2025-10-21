class Solution {
    // static int answer = Integer.MAX_VALUE;
    
    public int solution(int storey) {
        // dfs(storey, 0);
        // return answer;
        
        int result = 0;
        
        while(storey > 0) {
            int rest = storey % 10;
            storey /= 10;
            
            if(rest < 5) {
                result += rest;
            } else if(rest > 5) {
                result += (10 - rest);
                storey++;
            } else {
                result += 5;
                
                if(storey % 10 >= 5) {
                    storey++;
                }
            }
        }
        
        return result;
    }
    
//     private static void dfs(int storey, int count) {
//         if(storey / 10 == 0) {
//             count += Math.min(storey, 11 - storey);
//             answer = Math.min(answer, count);
//             return;
//         }
        
//         dfs(storey / 10, count + storey % 10);
//         dfs(storey / 10 + 1, count + 10 - (storey % 10));
//     }
}