class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // n의 2진수 1의 개수
        String str = Integer.toString(n, 2).replace("0", "");
        int cnt = str.length();
        
        int temp = n + 1;
        while(true) {
            // temp의 2진수 1의 개수
            String tStr = Integer.toString(temp, 2).replace("0", "");
            int tCnt = tStr.length();
            
            if(cnt == tCnt) {
                answer = temp;
                break;
            }
            
            temp++;
        }
        
        return answer;
    }
}