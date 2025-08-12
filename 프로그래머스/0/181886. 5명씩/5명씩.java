class Solution {
    public String[] solution(String[] names) {
        int len = names.length % 5 == 0 ? names.length / 5 : names.length / 5 + 1;
        String[] answer = new String[len];
        
        for(int i = 0, idx = 0; i < names.length; i += 5) {
            answer[idx++] = names[i];
        }
        
        return answer;
    }
}