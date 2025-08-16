class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        for(int i = 0; i < myString.length(); i++) {
            answer = myString.substring(i, myString.length()).startsWith(pat) ? ++answer : answer;
        }
        
        return answer;
    }
}