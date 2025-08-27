class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        int len = answer.length;
        
        if(direction.equals("right")) {
            for(int i = 0; i < len; i++) {
                answer[i] = numbers[(len - 1 + i) % len];
            }
        } else {
            for(int i = 0; i < len; i++) {
                answer[i] = numbers[(i + 1) % len];
            }
        }
        
        return answer;
    }
}