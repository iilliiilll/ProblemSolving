class Solution {
    public int solution(String s) {
        int answer = 0;

        char[] ch_arr = s.toCharArray();
        
        int cnt = 1;
        char ch = ch_arr[0];
        
        for(int i = 1; i < ch_arr.length; i++) {
            cnt += ch_arr[i] == ch ? 1 : -1;
            
            if(cnt == 0) {
                answer++;
                i++;
                
                if(i == ch_arr.length) {
                    break;
                } else {
                    ch = ch_arr[i];
                    cnt++;
                }
            }
        }
        
        if(cnt != 0) {
            answer++;
        }
        
        return answer;
    }
}