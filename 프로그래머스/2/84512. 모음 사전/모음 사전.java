class Solution {
    static int count = 0;
    static int answer = 0;
    static String[] arr = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    
    private static void dfs(String str, String target) {
        if(str.equals(target)) {
            answer = count;
            return;
        }
        
        if(str.length() == 5) {
            return;
        }
        
        for(String s : arr) {
            count++;
            dfs(str + s, target);
            
            if(answer != 0) {
                return;
            }
        }
    }
}