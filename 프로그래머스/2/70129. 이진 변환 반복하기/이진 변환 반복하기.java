class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zero = 0;
        
        while(!s.equals("1")) {
            // 제거할 0의 개수
            zero = s.length();
            s = s.replace("0", "");
            zero -= s.length();
            
            answer[1] += zero;
            
            // 0 제거 후 길이 -> 이진 변환 결과
            s = Integer.toString(s.length(), 2);
            
            // 카운트
            answer[0]++;
        }
        
        return answer;
    }
}